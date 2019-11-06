package za.co.ajk.messenger.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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

    @GET
    @Path("annotations")
    public String getParamsUsingAnnotations(@MatrixParam("matrixParam") String matrixParam,
                                            @HeaderParam("headerParam") String headerParam,
                                            @CookieParam("name")String cookie) {

        return "matrixParam : " + matrixParam + " and headerParam : " + headerParam +" cookie : "+cookie;
    }

}
