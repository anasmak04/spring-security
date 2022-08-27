package com.Log.LogJ.security;
import java.util.Set;
import com.google.common.collect.Sets;
import com.Log.LogJ.security.ApplicationUserPermission.*;

public enum ApplicationuserRole {
	STUDENT(Sets.newHashSet()),
	ADMIN(Sets.newHashSet(ApplicationUserPermission.COURSE_READ,ApplicationUserPermission.COURSE_WRITE,ApplicationUserPermission.STUDENT_READ,ApplicationUserPermission.STUDENT_WRITE));
	

	private final Set<ApplicationUserPermission> permissions;

	private ApplicationuserRole(Set<ApplicationUserPermission> permissions) {
		this.permissions = permissions;
	}
		
	public Set<ApplicationUserPermission> getPermissions() {
		return permissions;
	}
}
