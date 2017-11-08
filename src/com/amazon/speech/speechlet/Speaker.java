package com.amazon.speech.speechlet;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class Speaker {
  private final String speakerId;
  private final Integer confidence;
  
  /**
   * Returns a new builder instance used to construct a new {@code Speaker}.
   *
   * @return the builder
   */
  public static Builder builder() {
      return new Builder();
  }

  /**
   * Constructs a speaker.
   *
   * @param speakerId
   *            the speaker identifier
   * @deprecated use {@link Speaker#builder()} to construct new instances of this class
   */
  @Deprecated
  public Speaker(final String speakerId) {
      this(speakerId, null);
  }

  @SuppressWarnings("unused")
  private Speaker() {
      this(null, null);
  }

  /**
   * Private constructor to return a new {@code Speaker} from a {@code Builder}.
   *
   * @param builder
   *            the builder used to construct the {@code Speaker}
   */
  private Speaker(final Builder builder) {
      this.speakerId = builder.speakerId;
      this.confidence = builder.confidence;
  }

  /**
   * Private constructor used for JSON serialization.
   *
   * @param speakerId
   *            the user identifier
   * @param confidence
   *            the confidence
   */
  private Speaker(@JsonProperty("speakerId") final String speakerId,
          @JsonProperty("confidence") final Integer confidence) {
      this.speakerId = speakerId;
      this.confidence = confidence;
  }

  /**
   * Returns the speaker identifier.
   *
   * @return the speaker identifier
   */
  @JsonInclude(Include.NON_EMPTY)
  public String getSpeakerId() {
      return speakerId;
  }

  /**
   * Returns the confidence.
   *
   * @return the confidence.
   */
  @JsonInclude(Include.NON_EMPTY)
  public Integer getConfidence() {
      return confidence;
  }
  
  /**
   * Builder used to construct a new {@code Speaker}.
   */
  public static final class Builder {
    private String speakerId;
    private Integer confidence;

    private Builder() {
    }

    public Builder withSpeakerId(final String speakerId) {
        this.speakerId = speakerId;
        return this;
    }

    public Builder withConfidence(final Integer confidence) {
        this.confidence = confidence;
        return this;
    }

    public Speaker build() {
        return new Speaker(this);
    }
  }
}
