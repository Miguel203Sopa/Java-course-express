package gm.zona_fit.gui;

import gm.zona_fit.modelo.Cliente;
import gm.zona_fit.servicio.ClienteServicio;
import gm.zona_fit.servicio.IClienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

//@Component
public class ZonaFitForma extends JFrame {
    private JPanel panelPrincipal;
    private JTable clientesTabla;
    private JScrollPane scrollPane1;
    private JTextField nombreTexto;
    private JTextField apellidoTexto;
    private JTextField membresiaTexto;
    private JButton limpiarButton;
    private JButton guardarButton;
    private JButton eliminarButton;
    private DefaultTableModel  tablaModeloClientes;
    private Integer idCliente;

    IClienteServicio clienteServicio;

    @Autowired
    public ZonaFitForma(ClienteServicio clienteServicio) {
        this.clienteServicio = clienteServicio;
        iniciarForma();

        guardarButton.addActionListener(e -> guardarCliente());
        clientesTabla.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                cargarClienteSeleccionado();
            }
        });
        eliminarButton.addActionListener(e-> {
           eliminarCliente();
        });
        limpiarButton.addActionListener(e-> {
           limpiarFormulario();
        });
    }

    private void iniciarForma(){
        setContentPane(panelPrincipal);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(9000,700);
        setLocationRelativeTo(null);

    }




    private void createUIComponents() {
        // TODO: place custom component creation code here
        //this.tablaModeloClientes = new DefaultTableModel(0,4);
        this.tablaModeloClientes = new DefaultTableModel(0,4){
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };


        String[] cabeceros = {"Id","Nombre","Apellido","Membresia"};
        this.tablaModeloClientes.setColumnIdentifiers(cabeceros);
        this.clientesTabla = new JTable(tablaModeloClientes);


        //restringimos seleccion multiple de la tabla
        this.clientesTabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);


        //cargar listar clientes
        listarClientes();

    }

    private void listarClientes(){
        this.tablaModeloClientes.setRowCount(0);
        var clientes = this.clienteServicio.listarClientes();
        clientes.forEach( cliente -> {
            Object[] renglonCliente = {
                    cliente.getId(),
                    cliente.getNombre(),
                    cliente.getApellido(),
                    cliente.getMembresia()

            };
            this.tablaModeloClientes.addRow(renglonCliente);

        });
    }

    private void guardarCliente(){
        if(nombreTexto.getText().equals("")){
            mostrarMensaje("Proporciona un nombre");
            nombreTexto.requestFocusInWindow();
            return;
        }

        if(apellidoTexto.getText().equals("")){
            mostrarMensaje("Proporciona un apellido");
            apellidoTexto.requestFocusInWindow();
            return;
        }
        if(membresiaTexto.getText().equals("")){
            mostrarMensaje("Proporciona una membresia");
            membresiaTexto.requestFocusInWindow();
            return;
        }

        //valores del formulario
        var nombre = nombreTexto.getText();
        var apellido= apellidoTexto.getText();
        var membresia = Integer.parseInt(membresiaTexto.getText());
        var cliente = new Cliente(this.idCliente,nombre,apellido,membresia);
        this.clienteServicio.guardarCliente(cliente);

        if(this.idCliente == null){
            mostrarMensaje("se Agrego un nuevo cliente");
        }else{
            mostrarMensaje("se Modifico un cliente existente");
        }
        limpiarFormulario();
        listarClientes();



    }

    private void limpiarFormulario(){
        nombreTexto.setText("");
        apellidoTexto.setText("");
        membresiaTexto.setText("");

        //limpiar idCliente
        this.idCliente = null;

        //deseleccionar el registro :-/
        this.clientesTabla.getSelectionModel().clearSelection();
    }

    private void mostrarMensaje(String texto){
        JOptionPane.showMessageDialog(this, texto);
    }

    private void cargarClienteSeleccionado(){
        var renglon = clientesTabla.getSelectedRow();
        if(renglon != -1){
            var id = clientesTabla.getModel().getValueAt(renglon,0).toString();
            this.idCliente = Integer.parseInt(id);
            var nombre = clientesTabla.getModel().getValueAt(renglon,1).toString();
            this.nombreTexto.setText(nombre);
            var apellido = clientesTabla.getModel().getValueAt(renglon,2).toString();
            this.apellidoTexto.setText(apellido);
            var membresia = clientesTabla.getModel().getValueAt(renglon,3).toString();
            this.membresiaTexto.setText(membresia);
        }
    }

    private void eliminarCliente(){
        var renglon = clientesTabla.getSelectedRow();
        if(renglon != -1){
            var idClienteStr = clientesTabla.getModel().getValueAt(renglon,0).toString();
            this.idCliente =Integer.parseInt(idClienteStr);
            var cliente = new Cliente();
            cliente.setId(this.idCliente);
            clienteServicio.eliminarCliente(cliente);
            mostrarMensaje("Cliente con id "+this.idCliente+" ha sido eliminado");
            limpiarFormulario();
            listarClientes();
        }else{
            mostrarMensaje("Debe seleccionar un cliente a eliminar");
        }
    }

}