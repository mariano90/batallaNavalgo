package test.model.naves;

import junit.framework.Assert;
import main.model.disparos.Disparo;
import main.model.disparos.DisparoConvencional;
import main.model.disparos.TripleConRetardo;
import main.model.naves.Buque;
import main.model.naves.Nave;
import main.model.naves.EnumDirecciones.DireccionMovimiento;
import main.model.naves.EnumDirecciones.DireccionSentido;
import main.model.tablero.Coordenada;
import main.model.tablero.Tablero;
import org.junit.Test;

public class BuqueTest {
	@Test
	public void generarPartesTest(){
		Coordenada coordenada = new Coordenada(4,2);
		DireccionSentido sentido = DireccionSentido.HORIZONTAL;
		DireccionMovimiento movimiento = DireccionMovimiento.OESTE;
		Nave buque = new Buque(coordenada, sentido, movimiento);

		Assert.assertTrue(buque.getPartes().size() == 4);
	}

	@Test
	public void recibirMinaSubmarinaTest(){
		Coordenada coordenada = new Coordenada(4,2);
		DireccionSentido sentido = DireccionSentido.HORIZONTAL;
		DireccionMovimiento movimiento = DireccionMovimiento.OESTE;
		Nave buque = new Buque(coordenada, sentido, movimiento);
		Disparo disparo = new TripleConRetardo(coordenada);
		buque.recibirDisparo(disparo, buque.getPartes().get(0));

		Assert.assertTrue(buque.getPartes().get(0).estaDestruida());
		Assert.assertTrue(buque.estaDestruida());
	}

	@Test
	public void recibirDisparoConvencionalTest(){
		Coordenada coordenada = new Coordenada(4,2);
		DireccionSentido sentido = DireccionSentido.HORIZONTAL;
		DireccionMovimiento movimiento = DireccionMovimiento.OESTE;
		Nave buque = new Buque(coordenada, sentido, movimiento);
		Disparo disparo = new DisparoConvencional(coordenada);
		buque.recibirDisparo(disparo, buque.getPartes().get(0));

		Assert.assertTrue(buque.getPartes().get(0).estaDestruida());
		Assert.assertTrue(buque.estaDestruida());
	}

	@Test 
	public void ubicacionDeLaNaveTest(){
		Coordenada coordenadaInicio = new Coordenada(4,5);
		DireccionSentido sentido = DireccionSentido.VERTICAL;
		DireccionMovimiento movimiento = DireccionMovimiento.SUR;
		Nave buque = new Buque(coordenadaInicio, sentido, movimiento);

		Assert.assertTrue(buque.getPartes().get(0).getPosicion().equals(coordenadaInicio));
		Assert.assertTrue(buque.getPartes().get(1).getPosicion().equals(new Coordenada(5,5)));
		Assert.assertTrue(buque.getPartes().get(2).getPosicion().equals(new Coordenada(6,5)));
		Assert.assertTrue(buque.getPartes().get(3).getPosicion().equals(new Coordenada(7,5)));
		}

	@Test
	public void moverseHaciaArribaTest(){
		Coordenada coordenada = new Coordenada(5,5);
		DireccionSentido sentido = DireccionSentido.HORIZONTAL;
		DireccionMovimiento movimiento = DireccionMovimiento.NORTE;
		Nave buque = new Buque(coordenada, sentido, movimiento);
		Tablero.getTablero().getCasilleros()[coordenada.getX()][coordenada.getY()]
			.agregarNave(buque);
		buque.moverse();

		Assert.assertTrue(buque.getPartes().get(0).getPosicion().equals(new Coordenada(4,5)));
		Assert.assertTrue(buque.getPartes().get(1).getPosicion().equals(new Coordenada(4,6)));
		Assert.assertTrue(buque.getPartes().get(2).getPosicion().equals(new Coordenada(4,7)));
		Assert.assertTrue(buque.getPartes().get(3).getPosicion().equals(new Coordenada(4,8)));
	}

	@Test
	public void moverseHaciaAbajoTest(){
		Coordenada coordenada = new Coordenada(4,3);
		DireccionSentido sentido = DireccionSentido.VERTICAL;
		DireccionMovimiento movimiento = DireccionMovimiento.SUR;
		Nave buque = new Buque(coordenada, sentido, movimiento);
		Tablero.getTablero().getCasilleros()[coordenada.getX()][coordenada.getY()]
			.agregarNave(buque);
		buque.moverse();

		Assert.assertTrue(buque.getPartes().get(0).getPosicion().equals(new Coordenada(5,3)));
		Assert.assertTrue(buque.getPartes().get(1).getPosicion().equals(new Coordenada(6,3)));
		Assert.assertTrue(buque.getPartes().get(2).getPosicion().equals(new Coordenada(7,3)));
		Assert.assertTrue(buque.getPartes().get(3).getPosicion().equals(new Coordenada(8,3)));
	}

	@Test
	public void moverseHaciaElEsteTest(){
		Coordenada coordenada = new Coordenada(3,6);
		DireccionSentido sentido = DireccionSentido.VERTICAL;
		DireccionMovimiento movimiento = DireccionMovimiento.ESTE;
		Nave buque = new Buque(coordenada, sentido, movimiento);
		Tablero.getTablero().getCasilleros()[coordenada.getX()][coordenada.getY()]
			.agregarNave(buque);
		buque.moverse();

		Assert.assertTrue(buque.getPartes().get(0).getPosicion().equals(new Coordenada(3,7)));
		Assert.assertTrue(buque.getPartes().get(1).getPosicion().equals(new Coordenada(4,7)));
		Assert.assertTrue(buque.getPartes().get(2).getPosicion().equals(new Coordenada(5,7)));
		Assert.assertTrue(buque.getPartes().get(3).getPosicion().equals(new Coordenada(6,7)));
	}

	@Test
	public void moverseHaciaElOesteTest(){
		Coordenada coordenada = new Coordenada(6,6);
		DireccionSentido sentido = DireccionSentido.HORIZONTAL;
		DireccionMovimiento movimiento = DireccionMovimiento.OESTE;
		Nave buque = new Buque(coordenada, sentido, movimiento);
		Tablero.getTablero().getCasilleros()[coordenada.getX()][coordenada.getY()]
			.agregarNave(buque);
		buque.moverse();

		Assert.assertTrue(buque.getPartes().get(0).getPosicion().equals(new Coordenada(6,5)));
		Assert.assertTrue(buque.getPartes().get(1).getPosicion().equals(new Coordenada(6,6)));
		Assert.assertTrue(buque.getPartes().get(2).getPosicion().equals(new Coordenada(6,7)));
		Assert.assertTrue(buque.getPartes().get(3).getPosicion().equals(new Coordenada(6,8)));
	}

	@Test
	public void moverseHaciaElNoresteTest(){
		Coordenada coordenada = new Coordenada(5,4);
		DireccionSentido sentido = DireccionSentido.VERTICAL;
		DireccionMovimiento movimiento = DireccionMovimiento.NORESTE;
		Nave buque = new Buque(coordenada, sentido, movimiento);
		Tablero.getTablero().getCasilleros()[coordenada.getX()][coordenada.getY()]
			.agregarNave(buque);
		buque.moverse();

		Assert.assertTrue(buque.getPartes().get(0).getPosicion().equals(new Coordenada(4,5)));
		Assert.assertTrue(buque.getPartes().get(1).getPosicion().equals(new Coordenada(5,5)));
		Assert.assertTrue(buque.getPartes().get(2).getPosicion().equals(new Coordenada(6,5)));
		Assert.assertTrue(buque.getPartes().get(3).getPosicion().equals(new Coordenada(7,5)));
	}

	@Test
	public void moverseHaciaElNoroesteTest(){
		Coordenada coordenada = new Coordenada(6,5);
		DireccionSentido sentido = DireccionSentido.HORIZONTAL;
		DireccionMovimiento movimiento = DireccionMovimiento.NOROESTE;
		Nave buque = new Buque(coordenada, sentido, movimiento);
		Tablero.getTablero().getCasilleros()[coordenada.getX()][coordenada.getY()]
			.agregarNave(buque);
		buque.moverse();

		Assert.assertTrue(buque.getPartes().get(0).getPosicion().equals(new Coordenada(5,4)));
		Assert.assertTrue(buque.getPartes().get(1).getPosicion().equals(new Coordenada(5,5)));
		Assert.assertTrue(buque.getPartes().get(2).getPosicion().equals(new Coordenada(5,6)));
		Assert.assertTrue(buque.getPartes().get(3).getPosicion().equals(new Coordenada(5,7)));
	}

	@Test
	public void moverseHaciaElSuresteTest(){
		Coordenada coordenada = new Coordenada(4,3);
		DireccionSentido sentido = DireccionSentido.VERTICAL;
		DireccionMovimiento movimiento = DireccionMovimiento.SURESTE;
		Nave buque = new Buque(coordenada, sentido, movimiento);
		Tablero.getTablero().getCasilleros()[coordenada.getX()][coordenada.getY()]
			.agregarNave(buque);
		buque.moverse();

		Assert.assertTrue(buque.getPartes().get(0).getPosicion().equals(new Coordenada(5,4)));
		Assert.assertTrue(buque.getPartes().get(1).getPosicion().equals(new Coordenada(6,4)));
		Assert.assertTrue(buque.getPartes().get(2).getPosicion().equals(new Coordenada(7,4)));
		Assert.assertTrue(buque.getPartes().get(3).getPosicion().equals(new Coordenada(8,4)));
	}

	@Test
	public void moverseHaciaElSuroeste(){
		Coordenada coordenada = new Coordenada(3,6);
		DireccionSentido sentido = DireccionSentido.HORIZONTAL;
		DireccionMovimiento movimiento = DireccionMovimiento.SUROESTE;
		Nave buque = new Buque(coordenada, sentido, movimiento);
		Tablero.getTablero().getCasilleros()[coordenada.getX()][coordenada.getY()]
			.agregarNave(buque);
		buque.moverse();

		Assert.assertTrue(buque.getPartes().get(0).getPosicion().equals(new Coordenada(4,5)));
		Assert.assertTrue(buque.getPartes().get(1).getPosicion().equals(new Coordenada(4,6)));
		Assert.assertTrue(buque.getPartes().get(2).getPosicion().equals(new Coordenada(4,7)));
		Assert.assertTrue(buque.getPartes().get(3).getPosicion().equals(new Coordenada(4,8)));
	}
}