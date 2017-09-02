
public enum RoleFeautureCode {
	GETAPPCONFIGLIST(1),
	ADDAPPCONFIG(2),
	DELAPPCONFIG(3),
	UPDATEAPPCONFIG(4),
	
	
	ADMIN(100),
	ADMINREADONLY(101),
	DELEGATE(102),
	APPOWNER(103);
	
	
	private final int code;
	RoleFeautureCode(int code){
		this.code=code;
	}
        
    public int getCode() {
        return this.code;
    }

}
