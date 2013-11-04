/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shared;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface ButtonMethod {
	String buttonName() default "";        
	boolean isDefault() default false;
}
