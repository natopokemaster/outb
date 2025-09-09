package br.com.clarobr.contractprospectservice.models.common;


import br.com.clarobr.contractprospectservice.util.StringUtils;
import lombok.Data;
import org.springframework.lang.Nullable;

/**
 *  @author Almeida
 */
@Data
public class CustomHttpEntity<T> {
	
	@Nullable
    private T data;
	
	protected CustomHttpEntity() {
        this(null);
    }

    public CustomHttpEntity(@Nullable T data) {
        this.data = data;
    }
    
    public boolean hasBody() {
        return (!StringUtils.isNull(this.data));
    }

}
