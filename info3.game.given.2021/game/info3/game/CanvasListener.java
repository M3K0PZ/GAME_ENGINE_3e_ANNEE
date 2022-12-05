/*
 * Copyright (C) 2020  Pr. Olivier Gruber
 * Educational software for a basic game development
 * 
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 *  Created on: March, 2020
 *      Author: Pr. Olivier Gruber
 */
package info3.game;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;

import Entities.Key;
import info3.game.graphics.GameCanvasListener;

public class CanvasListener implements GameCanvasListener {
	Game m_game;
	Map<Integer, Boolean> keyboard;
	Boolean check = false;

	CanvasListener(Game game) {
		m_game = game;
		keyboard = new HashMap<Integer, Boolean>();
	}

	public boolean key(Key k) {
		try {
			switch (k) {
			case Z:
				return keyboard.get(90);
			case Q:
				return keyboard.get(81);
			case S:
				return keyboard.get(83);
			case D:
				return keyboard.get(68);
			case FU:
				return keyboard.get(38);
			case FL:
				return keyboard.get(37);
			case FD:
				return keyboard.get(40);
			case FR:
				return keyboard.get(39);
			case SPACE:
				return keyboard.get(32);
			case ENTER:
				return keyboard.get(10);
			case A:
				return keyboard.get(65);
			case E:
				return keyboard.get(69);
			default:
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("Mouse clicked: (" + e.getX() + "," + e.getY() + ")");
		System.out.println("   modifiers=" + e.getModifiersEx());
		System.out.println("   buttons=" + e.getButton());
	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("Mouse pressed: (" + e.getX() + "," + e.getY() + ")");
		System.out.println("   modifiers=" + e.getModifiersEx());
		System.out.println("   buttons=" + e.getButton());
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println("Mouse released: (" + e.getX() + "," + e.getY() + ")");
		System.out.println("   modifiers=" + e.getModifiersEx());
		System.out.println("   buttons=" + e.getButton());
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println("Mouse entered: (" + e.getX() + "," + e.getY() + ")");
		System.out.println("   modifiers=" + e.getModifiersEx());
		System.out.println("   buttons=" + e.getButton());
	}

	@Override
	public void mouseExited(MouseEvent e) {
		System.out.println("Mouse exited: (" + e.getX() + "," + e.getY() + ")");
		System.out.println("   modifiers=" + e.getModifiersEx());
		System.out.println("   buttons=" + e.getButton());
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		System.out.println("Mouse dragged: (" + e.getX() + "," + e.getY() + ")");
		System.out.println("   modifiers=" + e.getModifiersEx());
		System.out.println("   buttons=" + e.getButton());
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		System.out.println("Mouse moved: (" + e.getX() + "," + e.getY() + ")");
		System.out.println("   modifiers=" + e.getModifiersEx());
		System.out.println("   buttons=" + e.getButton());
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// System.out.println("Key typed: " + e.getKeyChar() + " code=" +
		// e.getKeyCode());
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// System.out.println("Key pressed: " + e.getKeyChar() + " code=" +
		// e.getKeyCode());
		check = keyboard.putIfAbsent(e.getKeyCode(), true);
		if (check == null)
			return;
		if (!check) {
			keyboard.replace(e.getKeyCode(), true);
		}

		/*
		 * switch (e.getKeyCode()) { case 37: case 38: case 39: case 40:
		 * m_game.m_cowboy.movet(e.getKeyCode()); break; case 81: case 83: case 90: case
		 * 68: m_game.m_cowboy2.movet(e.getKeyCode()); break; } ;
		 */
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// System.out.println("Key released: " + e.getKeyChar() + " code=" +
		// e.getKeyCode());
		keyboard.replace(e.getKeyCode(), false);

		/*
		 * switch (e.getKeyCode()) { case 37: case 38: case 39: case 40:
		 * m_game.m_cowboy.stop(e.getKeyCode()); break; case 81: case 83: case 90: case
		 * 68: m_game.m_cowboy2.stop(e.getKeyCode()); break; }
		 */
	}

	@Override
	public void tick(long elapsed) throws Exception {
		m_game.tick(elapsed);
	}

	@Override
	public void paint(Graphics g) {
		m_game.paint(g);
	}

	@Override
	public void windowOpened() {
		m_game.loadMusic();
//    m_game.m_canvas.setTimer(6000);
	}

	@Override
	public void exit() {
	}

//  boolean m_expired;
	@Override
	public void endOfPlay(String name) {
//    if (!m_expired) // only reload if it was a forced reload by timer
		m_game.loadMusic();
//    m_expired = false;
	}

	@Override
	public void expired() {
		// will force a change of music, after 6s of play
//    System.out.println("Forcing an ealy change of music");
//    m_expired = true;
//    m_game.loadMusic();    
	}

}
