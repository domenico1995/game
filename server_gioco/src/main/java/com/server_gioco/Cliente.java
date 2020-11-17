package org.server;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;
import com.google.gson.Gson;
import org.server.data.User;

public class Cliente {

    public static void main(String[] args){

        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:4321");
        
        Gson gson = new Gson();
        User a = new User("domenico", "100", "60");
        Response resp = target.path("user/add").request(MediaType.APPLICATION_JSON)
                .put(Entity.entity(gson.toJson(a), MediaType.APPLICATION_JSON));
        System.out.println(resp);
        System.out.println(resp.readEntity(String.class));
        
        resp = target.path("user/get/100").request(MediaType.APPLICATION_JSON).get();
        System.out.println(resp);
        System.out.println(resp.readEntity(String.class));
        
        //resp = target.path("user/delete/id200").request(MediaType.APPLICATION_JSON).delete();
        
    }

}
