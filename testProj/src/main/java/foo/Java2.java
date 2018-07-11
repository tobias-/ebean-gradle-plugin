package foo;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Java2 extends Kotlin1 {
    @Column
    private String attr1;

    public String getAttr1() {
	return attr1;
    }

    public void setAttr1(final String attr1) {
	this.attr1 = attr1;
    }
}
        