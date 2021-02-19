package functest.notNullCheck;

import lombok.Getter;
import lombok.Setter;

public class Company {
    @Getter @Setter private Long companyId;
    @Getter @Setter private String name;
}
