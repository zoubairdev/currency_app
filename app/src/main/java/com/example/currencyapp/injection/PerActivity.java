package com.example.currencyapp.injection;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * A scoping annotation to permit objects whose lifetime should
 * conform to the life of the Activity to be memorised in the
 * correct component.
 *
 * @author zoubair
 * @since 07/05/20
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerActivity {
}
