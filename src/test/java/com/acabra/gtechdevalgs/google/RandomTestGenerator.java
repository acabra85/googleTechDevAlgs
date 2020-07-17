package com.acabra.gtechdevalgs.google;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class RandomTestGenerator {

    private final Random rand;

    public RandomTestGenerator(long... args) {
        this.rand = args == null || args.length == 0 ? new Random() : new Random(args[0]);
    }

    private void addWordsAtRandomFromCategory(List<String> availableWords, int requiredValues, Set<String> uniqueRandomWords, AtomicInteger alreadyTaken) {
        if (requiredValues == 0) {
            return;
        }
        if (availableWords == null || availableWords.size() == 0) {
            throw new IllegalArgumentException("Given list of words must have at least one word");
        }
        int availableSize = availableWords.size() - alreadyTaken.get();
        if (requiredValues > availableSize) {
            throw new IllegalArgumentException(String.format("Requested words : %d but only %d are available", requiredValues, availableSize));
        }
        int totalWords = availableWords.size();
        int target = requiredValues + uniqueRandomWords.size();
        while (uniqueRandomWords.size() < target) {
            String word = availableWords.get(rand.nextInt(totalWords));
            if (!uniqueRandomWords.contains(word)) {
                uniqueRandomWords.add(word);
                alreadyTaken.incrementAndGet();
            }
        }
    }

    /**
     * This method retrieves words randomly from the given categories taking items from each category
     * in a proportional way, that is for each category elements taken will be proportional to the total
     * elements in all categories and according to the expected size.
     * 1. Calculate a proportion for each bucket by dividing the bucket size to the total words in all buckets
     * 2. For each bucket calculate the words needed according to totalRequested. (rounding down)
     * 3. At the end of iterating all buckets if there are countries missing:
     *    a. sort ascending order the categories not used
     */
    public List<String> generateFairRandomWordList(List<List<String>> wordCategories, int expectedSize) {
        int totalWords = wordCategories.stream().mapToInt(List::size).sum();
        if (expectedSize > totalWords) {
            throw new IllegalArgumentException(String.format("Requested random words {%d} but there are only {%d} available", expectedSize, totalWords));
        }
        if(expectedSize == 0) {
            return Collections.emptyList();
        }
        double[] proportions = new double[wordCategories.size()];
        int i = 0;

        Set<String> uniqueRandomWords = new HashSet<>();
        Map<Integer, AtomicInteger> counter = new HashMap<>();
        //first iteration
        for (List<String> category : wordCategories) {
            counter.put(i++, new AtomicInteger());
            proportions[i - 1] = expectedSize * category.size() * 1.0 / totalWords; // 1.4
            addWordsAtRandomFromCategory(category,
                    Double.valueOf(Math.floor(proportions[i - 1])).intValue(),
                    uniqueRandomWords,
                    counter.get(i - 1));
        }

        int missingWords = expectedSize - uniqueRandomWords.size();
        while (missingWords > 0) {
            List<Map.Entry<Integer, AtomicInteger>> pendingEntries = counter.entrySet()
                    .stream()
                    .sorted(new Comparator<Map.Entry<Integer, AtomicInteger>>() {
                        @Override
                        public int compare(Map.Entry<Integer, AtomicInteger> o1, Map.Entry<Integer, AtomicInteger> o2) {
                            int val1 = o1.getValue().get();
                            int val2 = o2.getValue().get();
                            return val1 != val2 ? val1-val2 : Double.compare(proportions[o2.getKey()], proportions[o1.getKey()]);
                        }
                    })
                    .collect(Collectors.toList());
            for(Map.Entry<Integer, AtomicInteger> entry: pendingEntries) {
                int request = Double.valueOf(Math.ceil(proportions[entry.getKey()])).intValue();
                addWordsAtRandomFromCategory(
                        wordCategories.get(entry.getKey()),
                        Math.min(request, missingWords),
                        uniqueRandomWords,
                        entry.getValue());
                missingWords = expectedSize - uniqueRandomWords.size();
                if (missingWords == 0) {
                    break;
                }
            }
        }

        List<String> uniqueWordList = new ArrayList<>(uniqueRandomWords.size());
        uniqueWordList.addAll(uniqueRandomWords);
        return uniqueWordList;
    }


}
