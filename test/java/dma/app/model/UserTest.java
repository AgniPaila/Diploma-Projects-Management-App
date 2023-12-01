package dma.app.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UserTest {
	
	private User user; 
	
	@BeforeEach
    public void setUp() {
		this.user = new User();
	}
	
	@Test
    public void getSetIdTest() {
        
        this.user.setId(0);
        assertEquals(0, this.user.getId());
    }
	
	@Test
    public void getSetPasswordTest() {
        
        this.user.setPassword("");
        assertEquals("", this.user.getPassword());
    }
	
	@Test
    public void getSetUsernameTest() {
        
        this.user.setUsername("");
        assertEquals("", this.user.getUsername());
    }
	
	@Test
    public void isAccountNonExpiredTest() {
        
        this.user.isAccountNonExpired();
        assertTrue(this.user.isAccountNonExpired());
    }
	
	@Test
    public void isAccountNonLockedTest() {
        
        this.user.isAccountNonLocked();
        assertTrue(this.user.isAccountNonLocked());
    }
	
	@Test
    public void isCredentialsNonExpiredTest() {
        
        this.user.isAccountNonExpired();
        assertTrue(this.user.isCredentialsNonExpired());
    }
	
	@Test
    public void isEnabledTest(){
        
        this.user.isEnabled();
        assertTrue(this.user.isEnabled());
    }
	
}