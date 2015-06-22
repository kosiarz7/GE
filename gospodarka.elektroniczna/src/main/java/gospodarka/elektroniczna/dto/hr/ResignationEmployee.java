package gospodarka.elektroniczna.dto.hr;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Future;

public class ResignationEmployee extends AbstractHrUser implements Serializable {

	/**
     * 
     */
	private static final long serialVersionUID = 1L;

	@Future
	private Date resignationDate;

	private String comment;

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getResignationDate() {
		return resignationDate;
	}

	public void setResignationDate(Date resignationDate) {
		this.resignationDate = resignationDate;
	}

	@Override
	public String toString() {
		return "ResignationEmployee [resignationDate=" + resignationDate
				+ ", comment=" + comment + ", userName=" + userName
				+ ", userSurname=" + userSurname + ", department=" + department
				+ "]";
	}


}
