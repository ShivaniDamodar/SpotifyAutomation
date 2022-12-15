
package spotify.oauth.pojo;

 
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
 

@JsonInclude(JsonInclude.Include.NON_NULL)
 
public class ExternalIds {

    @JsonProperty("isrc")
    private String isrc;

    @JsonProperty("isrc")
    public String getIsrc() {
        return isrc;
    }

    @JsonProperty("isrc")
    public void setIsrc(String isrc) {
        this.isrc = isrc;
    }

}
