/*
 * Copyright (c) 2009-2011. Created by serso aka se.solovyev.
 * For more information, please, contact se.solovyev@gmail.com
 * or visit http://se.solovyev.org
 */

package org.solovyev.android.calculator.view;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.AttributeSet;
import android.widget.TextView;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.solovyev.android.calculator.CalculatorLocatorImpl;
import org.solovyev.android.calculator.model.AndroidCalculatorEngine;

/**
 * User: serso
 * Date: 12/10/11
 * Time: 10:34 PM
 */
public class CalculatorAdditionalTitle extends TextView implements SharedPreferences.OnSharedPreferenceChangeListener {

	public CalculatorAdditionalTitle(Context context) {
		super(context);
	}

	public CalculatorAdditionalTitle(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public CalculatorAdditionalTitle(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	public void init(@NotNull SharedPreferences preferences) {
		onSharedPreferenceChanged(preferences, null);
	}

	@Override
	public void onSharedPreferenceChanged(SharedPreferences preferences, @Nullable String key) {
		setText(((AndroidCalculatorEngine) CalculatorLocatorImpl.getInstance().getEngine()).getNumeralBaseFromPrefs(preferences)
                + " / " +
                ((AndroidCalculatorEngine) CalculatorLocatorImpl.getInstance().getEngine()).getAngleUnitsFromPrefs(preferences));
	}
}