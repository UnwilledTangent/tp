package seedu.address.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Person's experience in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidExperience(String)}
 */
public class Experience {

    public static final String MESSAGE_CONSTRAINTS = "Experience can take any values, and it should not be blank";

    /*
     * The first character of the address must not be a whitespace,
     * otherwise " " (a blank string) becomes a valid input.
     */
    // public static final String VALIDATION_REGEX = "[^\\s].*";
    public static final String VALIDATION_REGEX = "\\w+";

    public final String value;

    /**
     * Constructs an {@code experience}.
     *
     * @param experience A valid experience.
     */
    public Experience(String experience) {
        requireNonNull(experience);
        checkArgument(isValidExperience(experience), MESSAGE_CONSTRAINTS);
        value = experience;
    }

    /**
     * Returns true if a given string is a valid email.
     */
    public static boolean isValidExperience(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Experience // instanceof handles nulls
                && value.equals(((Experience) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}
