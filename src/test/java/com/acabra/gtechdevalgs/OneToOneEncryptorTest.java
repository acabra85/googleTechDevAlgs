package com.acabra.gtechdevalgs;

import org.hamcrest.MatcherAssert;
import org.junit.Test;

public class OneToOneEncryptorTest {

    @Test
    public void should_return_true_both_strings_equal_reverseMap() {
        String plainText = "foo";
        String encryptedText = "foo";
        TestUtils.iAssertTrue(new OneToOneEncryptor().isOneToOneEncryptionPossibleForGivenPair(plainText, encryptedText));
    }
    @Test
    public void should_return_true_valid_encryption_1_reverseMap() {
        String plainText = "foo";
        String encryptedText = "juu";
        TestUtils.iAssertTrue(new OneToOneEncryptor().isOneToOneEncryptionPossibleForGivenPair(plainText, encryptedText));
    }
    @Test
    public void should_return_true_valid_encryption_2_reverseMap() {
        String plainText = "juu";
        String encryptedText = "foo";
        TestUtils.iAssertTrue(new OneToOneEncryptor().isOneToOneEncryptionPossibleForGivenPair(plainText, encryptedText));
    }

    @Test
    public void should_return_false_null_input_1_reverseMap() {
        String plainText = null;
        String encryptedText = "foo";
        TestUtils.iAssertFalse(new OneToOneEncryptor().isOneToOneEncryptionPossibleForGivenPair(plainText, encryptedText));
    }
    @Test
    public void should_return_false_null_input_2_reverseMap() {
        String plainText = "foo";
        String encryptedText = null;
        TestUtils.iAssertFalse(new OneToOneEncryptor().isOneToOneEncryptionPossibleForGivenPair(plainText, encryptedText));
    }
    @Test
    public void should_return_false_diff_input_lengths_reverseMap() {
        String plainText = "foo";
        String encryptedText = "booh";
        TestUtils.iAssertFalse(new OneToOneEncryptor().isOneToOneEncryptionPossibleForGivenPair(plainText, encryptedText));
    }
    @Test
    public void should_return_false_not_one_to_one_encryption_1_reverseMap() {
        String plainText = "foo";
        String encryptedText = "bar";
        TestUtils.iAssertFalse(new OneToOneEncryptor().isOneToOneEncryptionPossibleForGivenPair(plainText, encryptedText));
    }
    @Test
    public void should_return_false_not_one_to_one_encryption_2_reverseMap() {
        String plainText = "bar";
        String encryptedText = "foo";
        TestUtils.iAssertFalse(new OneToOneEncryptor().isOneToOneEncryptionPossibleForGivenPair(plainText, encryptedText));
    }

    @Test
    public void should_return_true_both_strings_equal_linearSearch() {
        String plainText = "foo";
        String encryptedText = "foo";
        TestUtils.iAssertTrue(new OneToOneEncryptor().isOneToOneEncryptionPossibleForGivenPairLinearSearch(plainText, encryptedText));
    }
    @Test
    public void should_return_true_valid_encryption_1_linearSearch() {
        String plainText = "foo";
        String encryptedText = "juu";
        TestUtils.iAssertTrue(new OneToOneEncryptor().isOneToOneEncryptionPossibleForGivenPairLinearSearch(plainText, encryptedText));
    }
    @Test
    public void should_return_true_valid_encryption_2_linearSearch() {
        String plainText = "juu";
        String encryptedText = "foo";
        TestUtils.iAssertTrue(new OneToOneEncryptor().isOneToOneEncryptionPossibleForGivenPairLinearSearch(plainText, encryptedText));
    }

    @Test
    public void should_return_false_null_input_1_linearSearch() {
        String plainText = null;
        String encryptedText = "foo";
        TestUtils.iAssertFalse(new OneToOneEncryptor().isOneToOneEncryptionPossibleForGivenPairLinearSearch(plainText, encryptedText));
    }
    @Test
    public void should_return_false_null_input_2_linearSearch() {
        String plainText = "foo";
        String encryptedText = null;
        TestUtils.iAssertFalse(new OneToOneEncryptor().isOneToOneEncryptionPossibleForGivenPairLinearSearch(plainText, encryptedText));
    }
    @Test
    public void should_return_false_diff_input_lengths_linearSearch() {
        String plainText = "foo";
        String encryptedText = "booh";
        TestUtils.iAssertFalse(new OneToOneEncryptor().isOneToOneEncryptionPossibleForGivenPairLinearSearch(plainText, encryptedText));
    }
    @Test
    public void should_return_false_not_one_to_one_encryption_1_linearSearch() {
        String plainText = "foo";
        String encryptedText = "bar";
        TestUtils.iAssertFalse(new OneToOneEncryptor().isOneToOneEncryptionPossibleForGivenPairLinearSearch(plainText, encryptedText));
    }
    @Test
    public void should_return_false_not_one_to_one_encryption_2_linearSearch() {
        String plainText = "bar";
        String encryptedText = "foo";
        TestUtils.iAssertFalse(new OneToOneEncryptor().isOneToOneEncryptionPossibleForGivenPairLinearSearch(plainText, encryptedText));
    }
}
