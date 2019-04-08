package com.acabra.gtechdevalgs.litcode.graphs;

public class FindCelebrity extends Relation {

    public FindCelebrity(boolean[][] graph) {
        super(graph);
    }

    /**
     * Everyone knows he celebrity and the celebrity knows no one
     * @param n
     * @return
     */
    public int findCelebrity(int n) {
        int peopleCount = n;
        if (peopleCount<2) return -1; //if there is just 1 person it can't be a celebrity since no-one knows him/her
        int celeb = 0; //take the first person

        for (int i = 1; i < peopleCount; i++) {//find a person that knows no-one
            if (knows(celeb, i)) {
                celeb = i;
            }
        }

        //everyone knows the celebrity
        for (int i = 0; i < peopleCount; i++) {
            if (celeb!=i && (!knows(i, celeb) || knows(celeb, i))) {
                return -1;
            }
        }
        return celeb;
    }
}
