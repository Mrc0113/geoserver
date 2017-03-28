package org.geoserver.rest.wrapper;

import org.geoserver.config.util.XStreamPersister;
import org.geoserver.rest.converters.FreemarkerHTMLMessageConverter;
import org.geoserver.rest.converters.XStreamMessageConverter;

import freemarker.template.Template;

/**
 * Wrapper for objects returned by MVC Rest endpoints
 */
public interface RestWrapper<T> {
    /**
     * Get the class of object or collection contents, if the object is a collection
     *
     * @return class of the object
     */
    Class<T> getObjectClass();

    /**
     * Get the wrapped object
     *
     * May return either an instace of {@link #getObjectClass()} or a collection of instances of that class.
     *
     * @return wrapped object
     */
    Object getObject();

    /**
     * Apply configuration to the XStreamPersister based on the data format
     *
     * @param persister The XStream persister
     * @param xStreamMessageConverter 
     * 
     */
    void configurePersister(XStreamPersister persister, XStreamMessageConverter xStreamMessageConverter);

    /**
     * Apply configuration to the template based on the data format
     *
     * @param converter the {@link FreemarkerHTMLMessageConverter} to use 
     * 
     */
    void configureFreemarker(FreemarkerHTMLMessageConverter converter);
    
    /**
     * Get the freemarker template associated with this response
     *
     * @return the freemarker template
     */
    Template getTemplate();
}