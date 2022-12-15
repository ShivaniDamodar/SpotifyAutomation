
package spotify.oauth.pojo;

 
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
 

@JsonInclude(JsonInclude.Include.NON_NULL)
 
public class VideoThumbnail {

    @JsonProperty("url")
    private Object url;

    @JsonProperty("url")
    public Object getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(Object url) {
        this.url = url;
    }

}
