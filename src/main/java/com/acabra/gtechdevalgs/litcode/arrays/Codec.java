package com.acabra.gtechdevalgs.litcode.arrays;

import java.util.ArrayList;
import java.util.List;

class Codec {
    public String encode(List<String> input) {
        String sepKey = "\0&%\'";
        String encodeEmpty = "XXXX_&_&_XXXX";
        StringBuilder sb = new StringBuilder().append(input.size()).append(sepKey);
        for (int i = 0; i < input.size(); i++) {
            String str = input.get(i);
            sb.append(str.length() == 0 ? encodeEmpty : str)
                    .append(sepKey);
        }
        return sb.toString();
    }

    public List<String> decode(String encode) {
        if (encode == null) throw new NullPointerException("encoded string is null");
        String sepKey = "\0&%\'";
        String encodeEmpty = "XXXX_&_&_XXXX";
        int index = encode.indexOf(sepKey);
        if (index <= 0) {
            throw new IllegalArgumentException("input has an invalid encoding format");
        }
        int size = Integer.parseInt(encode.substring(0, index));
        List<String> decoded = new ArrayList<>(size);
        String substring = encode.substring(index + sepKey.length());
        String[] tokenizer = substring.split(sepKey);
        for (int i = 0; i < tokenizer.length && i < size; i++) {
            decoded.add(tokenizer[i].equals(encodeEmpty) ? "" : tokenizer[i]);
        }
        return decoded;
    }
}
