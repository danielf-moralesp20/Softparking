package com.dfm.softparking.views.utils.forms;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BooleanSupplier;
import java.util.function.Supplier;

import org.kordamp.ikonli.javafx.FontIcon;
import org.kordamp.ikonli.materialdesign.MaterialDesign;

import com.dfm.softparking.views.utils.forms.validators.EmailValidator;
import com.jfoenix.validation.DoubleValidator;
import com.jfoenix.validation.IntegerValidator;
import com.jfoenix.validation.NumberValidator;
import com.jfoenix.validation.RegexValidator;
import com.jfoenix.validation.RequiredFieldValidator;
import com.jfoenix.validation.base.ValidatorBase;

import javafx.scene.control.TextField;

public class FormControl {
	public static enum EValidators {
		DOUBLE(() -> new DoubleValidator()),
		EMAIL(() -> new EmailValidator()),
		INTEGER(() -> new IntegerValidator()),
		NUMBER(() -> new NumberValidator()),
		REGEX(() -> new RegexValidator()),
		REQUIRED(() -> new RequiredFieldValidator());
		
		private Supplier<ValidatorBase> constructor;
		
		private EValidators(Supplier<ValidatorBase> constructor) {
			this.constructor = constructor;
		}
		
		public ValidatorBase getNewInstance() {
			return constructor.get();
		}
	}
	
	private Map<TextField, BooleanSupplier> formValidators;
	private EnumMap<EValidators, String> defaultMessages;

	public FormControl() {
		formValidators = new HashMap<>();	
		defaultMessages = new EnumMap<>(EValidators.class);
	}
	
	public FormControl(EnumMap<EValidators, String> defaultMessages) {
		this();
		this.defaultMessages = defaultMessages;
	}
	
	public List<ValidatorBase> add(TextField field, BooleanSupplier validator, EnumSet<EValidators> eValidators) {
		EnumMap<EValidators, String> helper = new EnumMap<>(EValidators.class);
		eValidators.forEach((val) -> helper.put(val, null));
		
		return add(field, validator, helper);
	}
	
	public List<ValidatorBase> add(TextField field, BooleanSupplier validator, EnumMap<EValidators, String> eValidators) {
		List<ValidatorBase> result = new ArrayList<>();
		
		eValidators.forEach((key, val) -> {
			String message = Optional.ofNullable(val).orElse(defaultMessages.get(key));	
			ValidatorBase validatorBase = key.getNewInstance();
			
			validatorBase.setMessage(message);
			validatorBase.setIcon(FontIcon.of(MaterialDesign.MDI_ALERT_OCTAGON, 18));
			
			result.add(0, validatorBase);
		});
		
		field.textProperty().addListener((observable, oldValue, newValue) -> validate(field, validator));
		formValidators.put(field, validator);
		
		return result;
	}
	
	public boolean validate() {
		boolean aux = true;
		
		for(Map.Entry<TextField, BooleanSupplier> val : formValidators.entrySet()) {
			boolean result = validate(val.getKey(), val.getValue());
			if(aux) aux = result;
		}
		
		return aux;
	}
	
	private boolean validate(TextField field, BooleanSupplier validator) {
		boolean aux = validator.getAsBoolean();
		
		if(aux)
			field.getStyleClass().remove("errorInput");
		else {
			if(!field.getStyleClass().contains("errorInput"))
				field.getStyleClass().add("errorInput");
		}
		
		return aux;
	}
}
