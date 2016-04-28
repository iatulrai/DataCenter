package com.client;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class ChatClient {
	JTextArea in;
	JTextField out;
	BufferedReader reader;
	PrintWriter writer;
	Socket sock;

	public void go() {
		JFrame frame = new JFrame("Welcome to Atul Rai's Chat Software");

		JPanel mainPanel = new JPanel();
		in = new JTextArea(15, 50);
		in.setLineWrap(true);
		in.setWrapStyleWord(true);
		in.setEditable(false);

		JScrollPane scroll = new JScrollPane(in);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

		out = new JTextField(20);

		JButton sendButton = new JButton("Send");
		sendButton.addActionListener(new SendButtonListener());

		mainPanel.add(scroll);
		mainPanel.add(out);
		mainPanel.add(sendButton);

		frame.getContentPane().add(BorderLayout.CENTER, mainPanel);

		setUpNetworking();

		Thread readerThread = new Thread(new IncomingReader());
		readerThread.start();

		frame.setSize(650, 500);
		frame.setVisible(true);

	} // close go

	private void setUpNetworking() {

		try {

			sock = new Socket("127.0.0.1", 4410); // 127.0.0.1 is local IP and
													// 4410 is port
			InputStreamReader streamReader = new InputStreamReader(
					sock.getInputStream());
			reader = new BufferedReader(streamReader);
			writer = new PrintWriter(sock.getOutputStream());

			System.out.println("Networikng Established");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public class SendButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent ev) {
			try {
				writer.println(out.getText());
				writer.flush();

			} catch (Exception ex) {
				ex.printStackTrace();
			}
			out.setText("");
			out.requestFocus();
		}
	}

	public static void main(String[] args) {
		new ChatClient().go();
	}

	class IncomingReader implements Runnable {

		public void run() {

			String message;

			try {

				while ((message = reader.readLine()) != null) {
					System.out.println("client read " + message);
					in.append(message + "\n");
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}
