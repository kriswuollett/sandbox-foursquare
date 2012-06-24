/**
 * Copyright 2012 Kristopher Wuollett
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package kriswuollett.sandbox.foursquare.api;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.annotations.AnnotationConfiguration;
import org.eclipse.jetty.plus.webapp.EnvConfiguration;
import org.eclipse.jetty.plus.webapp.PlusConfiguration;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.Configuration;
import org.eclipse.jetty.webapp.FragmentConfiguration;
import org.eclipse.jetty.webapp.MetaInfConfiguration;
import org.eclipse.jetty.webapp.TagLibConfiguration;
import org.eclipse.jetty.webapp.WebAppContext;
import org.eclipse.jetty.webapp.WebInfConfiguration;
import org.eclipse.jetty.webapp.WebXmlConfiguration;

@WebServlet(name = "HelloServlet", urlPatterns = { "/hello" })
public class HelloServlet extends HttpServlet
{

    private static final long serialVersionUID = -911272966648931058L;

    @Override
    protected void doGet( HttpServletRequest req, HttpServletResponse resp )
            throws ServletException, IOException
    {
        ServletOutputStream out = resp.getOutputStream();
        out.write( "Hello World from a Servlet!".getBytes() );
        out.flush();
        out.close();
    }

    public static void main( String[] args ) throws Exception
    {
        Server server = new Server( Integer.valueOf( System.getenv( "PORT" ) ) );
        WebAppContext context = new WebAppContext();
        context.setResourceBase( "kriswuollett-sandbox-foursquare-web/target/kriswuollett-sandbox-foursquare-web" );
        context.setContextPath( "/" );
        context.setParentLoaderPriority( true );
        context.setConfigurations( new Configuration[] {
                new AnnotationConfiguration(), new WebXmlConfiguration(),
                new WebInfConfiguration(), new TagLibConfiguration(),
                new PlusConfiguration(), new MetaInfConfiguration(),
                new FragmentConfiguration(), new EnvConfiguration() } );
        server.setHandler( context );
        server.start();
        server.join();
    }
}
