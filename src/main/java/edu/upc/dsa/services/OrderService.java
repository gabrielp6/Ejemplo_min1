package edu.upc.dsa.services;


import edu.upc.dsa.*;
import edu.upc.dsa.models.Track;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Api(value = "/orders", description = "Endpoint to Orders Service")
@Path("/orders")
public class OrderService {

    private ProductManagerImple pm;

    public OrderService() {
        this.pm = ProductManagerImple.getInstance();

        //Añadimos clientes
        this.pm.addClient("1",new User("Carlos"));
        this.pm.addClient("2",new User("Sebastian"));
        this.pm.addClient("3",new User("Federico"));

        //Añadimos Productos
        this.pm.addProducts("Coca cola",2,20);
        this.pm.addProducts("Donut",8, 20);
        this.pm.addProducts("Bocata de jamon",3 ,30);

    }
    @GET
    @ApiOperation(value = "get all Products by sales", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Product.class, responseContainer="List"),
    })
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllProductsBySales() {

        List<Product> products1 = this.pm.getProductBySales();

        GenericEntity<List<Product>> entity1 = new GenericEntity<List<Product>>(products1) {};
        return Response.status(201).entity(entity1).build();

    }
    @GET
    @ApiOperation(value = "get all Products by price", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Product.class, responseContainer="List"),
    })
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllProductsByPrice() {

        List<Product> products = this.pm.getProductByPrice();

        GenericEntity<List<Product>> entity = new GenericEntity<List<Product>>(products) {};
        return Response.status(201).entity(entity).build();

    }

    @POST
    @ApiOperation(value = "Add a order", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response=Order.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })

    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response newTrack(OrderVO order) {
        System.out.println("Nueva order");
        if (order.getUsuario() == null || order.getProductList() == null)  return Response.status(500).entity(order).build();
        else{
            Order or = new Order();
            or.setUsuario(order.getUsuario());
            for (int i = 0; i < order.getProductList().size(); i++) {
                //or.addProduct(order.getProductList().get(i),);
            }

            return Response.status(404).build();
        }
        //this.pm.newOrder(order);

    }
    //Listado de pedidos de un usuario que ya hayan sido realizados
    @GET
    @ApiOperation(value = "get list of orders", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Order.class),
            @ApiResponse(code = 404, message = "Track not found")
    })
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOrderUser(@PathParam("id") String id) {

        List<Order> orders = this.pm.getOrderByUser(id);
        if (orders == null) return Response.status(404).build();
        else{  //return Response.status(201).entity(t).build();

            GenericEntity<List<Order>> entity = new GenericEntity<List<Order>>(orders) {};
            return Response.status(201).entity(entity).build();
        }
    }



   /* @GET
    @ApiOperation(value = "get aa Track", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Track.class),
            @ApiResponse(code = 404, message = "Track not found")
    })
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTrack(@PathParam("id") String id) {
        Track t = this.tm.getTrack(id);
        if (t == null) return Response.status(404).build();
        else  return Response.status(201).entity(t).build();
    }

    @DELETE
    @ApiOperation(value = "delete a Track", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "Track not found")
    })
    @Path("/{id}")
    public Response deleteTrack(@PathParam("id") String id) {
        Track t = this.tm.getTrack(id);
        if (t == null) return Response.status(404).build();
        else this.tm.deleteTrack(id);
        return Response.status(201).build();
    }

    @PUT
    @ApiOperation(value = "update a Track", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "Track not found")
    })
    @Path("/")
    public Response updateTrack(Track track) {

        Track t = this.tm.updateTrack(track);

        if (t == null) return Response.status(404).build();

        return Response.status(201).build();
    }



    @POST
    @ApiOperation(value = "create a new Track", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response=Track.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })

    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newTrack(Track track) {

        if (track.getSinger()==null || track.getTitle()==null)  return Response.status(500).entity(track).build();
        this.tm.addTrack(track);
        return Response.status(201).entity(track).build();
    }*/

}