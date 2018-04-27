
package jsonapp1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "numbers"
})
public class Document implements Serializable
{

    @JsonProperty("numbers")
    @Valid
    private List<Long> numbers = new ArrayList<Long>();
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 9042713923766428124L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Document() {
    }

    /**
     * 
     * @param numbers
     */
    public Document(List<Long> numbers) {
        super();
        this.numbers = numbers;
    }

    @JsonProperty("numbers")
    public List<Long> getNumbers() {
        return numbers;
    }

    @JsonProperty("numbers")
    public void setNumbers(List<Long> numbers) {
        this.numbers = numbers;
    }

    public Document withNumbers(List<Long> numbers) {
        this.numbers = numbers;
        return this;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public Document withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("numbers", numbers).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(numbers).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Document) == false) {
            return false;
        }
        Document rhs = ((Document) other);
        return new EqualsBuilder().append(numbers, rhs.numbers).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
