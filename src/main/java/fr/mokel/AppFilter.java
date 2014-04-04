package fr.mokel;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

import org.apache.wicket.protocol.http.WicketFilter;

@WebFilter(value = "/*", initParams = { 
								@WebInitParam(name = "applicationClassName", value = "org.apache.wicket.examples.library.LibraryApplication"), 
								@WebInitParam(name="filterMappingUrlPattern", value="/*") })
public class AppFilter extends WicketFilter {

}
