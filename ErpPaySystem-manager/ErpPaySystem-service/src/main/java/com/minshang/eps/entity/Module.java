package com.minshang.eps.entity;

public class Module implements Comparable<Module>{
    private Integer moduleid;

    private String modulename;

    private Byte moduletype;

    private Byte state;

    private String url;
    
    private String rolename;
    
    private String parentid;

    public Integer getModuleid() {
        return moduleid;
    }

    public void setModuleid(Integer moduleid) {
        this.moduleid = moduleid;
    }

    public String getModulename() {
        return modulename;
    }

    public void setModulename(String modulename) {
        this.modulename = modulename == null ? null : modulename.trim();
    }

    public Byte getModuletype() {
        return moduletype;
    }

    public void setModuletype(Byte moduletype) {
        this.moduletype = moduletype;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public String getParentid() {
		return parentid;
	}

	public void setParentid(String parentid) {
		this.parentid = parentid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((moduleid == null) ? 0 : moduleid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Module other = (Module) obj;
		if (moduleid == null) {
			if (other.moduleid != null)
				return false;
		} else if (!moduleid.equals(other.moduleid))
			return false;
		return true;
	}

	@Override
	public int compareTo(Module o) {
		// TODO Auto-generated method stub		
		return this.getModuleid().compareTo(o.getModuleid());
	}

	
	
}