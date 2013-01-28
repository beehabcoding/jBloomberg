/*
 * Copyright (C) 2012 - present by Yann Le Tallec.
 * Please see distribution for license.
 */
package assylias.jbloomberg;

import java.util.HashSet;
import java.util.Set;
import org.joda.time.DateTime;

/**
 * A basic implementation of the RequestResult interface, that only deals with errors.
 */
abstract class AbstractRequestResult implements RequestResult {

    /**
     * A set of security identifiers that returned error messages - can be empty
     */
    private final Set<String> securityErrors = new HashSet<>();
    /**
     * A set of fields that returned error messages - can be empty
     */
    private final Set<String> fieldErrors = new HashSet<>();

    @Override
    public synchronized boolean hasErrors() {
        return !(securityErrors.isEmpty() && fieldErrors.isEmpty());
    }

    @Override
    public synchronized Set<String> getFieldErrors() {
        return fieldErrors;
    }

    @Override
    public synchronized Set<String> getSecurityErrors() {
        return securityErrors;
    }

    synchronized void addSecurityError(String security) {
        securityErrors.add(security);
    }

    synchronized void addFieldError(String field) {
        fieldErrors.add(field);
    }

    void add(DateTime date, String security, String field, Object value) {
        throw new UnsupportedOperationException("Subclasses need to override this method if it is required");
    }

    void add(DateTime date, String field, Object value) {
        throw new UnsupportedOperationException("Subclasses need to override this method if it is required");
    }

    void add(String security, String field, Object value) {
        throw new UnsupportedOperationException("Subclasses need to override this method if it is required");
    }
    void add(DateTime date, Object value) {
        throw new UnsupportedOperationException("Subclasses need to override this method if it is required");
    }
}
