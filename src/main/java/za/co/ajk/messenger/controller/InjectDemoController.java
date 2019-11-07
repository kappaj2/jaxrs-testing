package za.co.ajk.messenger.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriInfo;

@Path("/injectdemo")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class InjectDemoController {

    //http://localhost:8080/messenger_war/webapi/injectdemo/annotations;param=value

//    @GET
//    @Path("annotations")
//    public String getParamsUsingAnnotations(@MatrixParam("matrixParam") String matrixParam) {
//        return "matrixParam : " + matrixParam ;
//    }


//    @GET
//    @Path("annotations")
//    public String getParamsUsingAnnotations(@MatrixParam("matrixParam") String matrixParam,
//                                            @HeaderParam("headerParam") String headerParam) {
//        return "matrixParam : " + matrixParam + " and headerParam : " + headerParam;
//    }

    //  Also use BeanParam and add these annotations to that class and then use Jersey to inhect that bean.
    @GET
    @Path("annotations")
    public String getParamsUsingAnnotations(@MatrixParam("matrixParam") String matrixParam,
                                            @HeaderParam("headerParam") String headerParam,
                                            @CookieParam("name")String cookie) {

        return "matrixParam : " + matrixParam + " and headerParam : " + headerParam +" cookie : "+cookie;
    }

    @GET
    @Path("context")
    public String getParamsUsingContext(@Context UriInfo uriInfo, @Context HttpHeaders httpHeaders){

        String absPAth = uriInfo.getAbsolutePath().toString();
        System.out.println("Abs path : "+absPAth);

        MultivaluedMap<String, String> requestHeaders = httpHeaders.getRequestHeaders();
        return "test ";
    }
}
