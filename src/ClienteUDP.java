import java.net.*;
import java.nio.charset.StandardCharsets;
import java.io.*;


public class ClienteUDP {
	
	// args proporciona el mensaje y el nombre del servidor
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			DatagramSocket unSocket = new DatagramSocket(6789);
			byte[] msj = args[0].getBytes();
			//InetAddress unHost = InetAddress.getByName("juancarlosamor.es");
			InetSocketAddress unHost = new InetSocketAddress("192.168.1.139", 6789);
			System.out.println(unHost.getHostString() + unHost.toString());
			//int puertoServidor = 6789;
			DatagramPacket peticion = new DatagramPacket(msj, args[0].length(), unHost);
			String s = new String(msj, StandardCharsets.UTF_8);
			System.out.println("msj como String: "+ s);
			unSocket.send(peticion);
			
			byte [] bufer = new byte[1000];
			DatagramPacket respuesta = new DatagramPacket(bufer, bufer.length);
			System.out.println("Empieza la respuesta con los datos: peticion: " + new String(peticion.getData()) + " Ip: "+ unHost.toString());
			unSocket.receive(respuesta);
			System.out.println("Ha recibido...");
			System.out.println("Respuesta: " + new String(respuesta.getData()));
			unSocket.close();
			
		}catch (SocketException e) {
			System.out.println("Socket: " + e.getMessage());
		}catch (IOException e) {
			System.out.println("IO: " + e.getMessage());
		}

	}

}
