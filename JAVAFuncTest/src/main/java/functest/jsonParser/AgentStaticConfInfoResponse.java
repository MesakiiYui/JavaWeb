package functest.jsonParser;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: jintienan
 * @Date: 2021/6/1 10:59
 */
@Data
public class AgentStaticConfInfoResponse implements Serializable {

    private static final long serialVersionUID = -3741918789372592547L;

    private Integer agentId;

    private Integer groupId;

    private String rights;

    private String name;

    private Integer realFlg;


}
