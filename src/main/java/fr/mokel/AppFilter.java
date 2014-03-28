package fr.mokel;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

import org.apache.wicket.protocol.http.WicketFilter;

@WebFilter(value = "/*", initParams = { 
								@WebInitParam(name = "applicationClassName", value = "fr.mokel.WicketApplication"), 
								@WebInitParam(name="filterMappingUrlPattern", value="/*") })
public class AppFilter extends WicketFilter {

}
