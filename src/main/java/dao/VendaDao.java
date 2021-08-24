package dao;

import entidade.Cliente;
import entidade.Produto;
import entidade.Usuario;
import entidade.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.Conexao;

public class VendaDao {

    private Connection conexao = Conexao.getConexao();

    public static void main(String[] args) {
        
        Date data = new Date();
        String dataHoje = DateFormat.getDateInstance().format(data);
        
        Usuario usuario = new Usuario();
        usuario.setNome("André");

        Cliente cliente = new Cliente();
        cliente.setNome("Paulo");

        Produto produto = new Produto();
        produto.setNome("tomada");
        produto.setPrecoVenda(17.00);
        produto.setQuantidade(1);

        Venda venda = new Venda();
        venda.setId(3);
        venda.setUsuario(usuario);
        venda.setCliente(cliente);
        venda.setData(dataHoje);
        venda.setProduto(produto);
        venda.setPrecoTotal(produto.getPrecoVenda() * produto.getQuantidade());
        
        VendaDao vendaDao = new VendaDao();
        
        //1) CADASTRAR UMA VENDA
        
        vendaDao.inserir(venda);
        
        //2) ATUALIZAR OS DADOS DE UMA VENDA
        
        //vendaDao.atualizar(venda);
        
        //3) LISTAR TODAS AS VENDAS
        
        //List<Venda> vendas = vendaDao.listar();
        /* System.out.println("==============");
        System.out.println("TABELA VENDA");
        System.out.println("==============");
        for (Venda vd : vendas) {
            System.out.println("Id: " + vd.getId());
            System.out.println("Usuario: " + vd.getUsuario().getNome());
            System.out.println("Cliente: " + vd.getCliente().getNome());
            System.out.println("Data venda: " + vd.getData());
            System.out.println("Produto: " + vd.getProduto().getNome());
            System.out.println("Preco unitário:" + vd.getProduto().getPrecoVenda());
            System.out.println("Quantidade:" + vd.getProduto().getQuantidade());
            System.out.println("Total:" + vd.getPrecoTotal());
            System.out.println("--------------------");
        }*/
        
        //4) BUSCAR OS DADOS DE UMA VENDA: INSERIR A ID COMO PARAMETRO
        //DO METODO buscar()
        
        //Venda venda = vendaDao.buscar(1);
        /*System.out.println("================");
        System.out.println("DADOS DA VENDA");
        System.out.println("================");
        System.out.println("Id: " + venda.getId());
        System.out.println("Usuario: " + venda.getUsuario().getNome());
        System.out.println("Cliente: " + venda.getCliente().getNome());
        System.out.println("Data venda: " + venda.getData());
        System.out.println("Produto: " + venda.getProduto().getNome());
        System.out.println("Preco unitário:" + venda.getProduto().getPrecoVenda());
        System.out.println("Quantidade:" + venda.getProduto().getQuantidade());
        System.out.println("Total:" + venda.getPrecoTotal());
        System.out.println("--------------------");*/
        
        //5) REMOVER UMA VENDA: INSERIR A ID COMO PARAMETRO
        //DO METODO remover()
        //vendaDao.remover(4);
        
    }

    public void inserir(Venda venda) {
        try {
            PreparedStatement stmt = conexao.prepareStatement("INSERT INTO venda (usuario,cliente,data,produto,precoVenda,quantidade,precoTotal) VALUES(?,?,?,?,?,?,?)");
            stmt.setString(1, venda.getUsuario().getNome());
            stmt.setString(2, venda.getCliente().getNome());
            stmt.setString(3, venda.getData());
            stmt.setString(4, venda.getProduto().getNome());
            stmt.setDouble(5, venda.getProduto().getPrecoVenda());
            stmt.setDouble(6, venda.getProduto().getQuantidade());
            stmt.setDouble(7, venda.getPrecoTotal());
            stmt.executeUpdate();
            stmt.close();
            conexao.close();
            System.out.println("Venda cadastrada com sucesso");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void atualizar(Venda venda) {
        try {
            PreparedStatement stmt = conexao.prepareStatement("UPDATE venda SET usuario=?,cliente=?,data=?,produto=?,precoVenda=?,quantidade=?,precoTotal=? WHERE id=?");
            stmt.setString(1, venda.getUsuario().getNome());
            stmt.setString(2, venda.getCliente().getNome());
            stmt.setString(3, venda.getData());
            stmt.setString(4, venda.getProduto().getNome());
            stmt.setDouble(5, venda.getProduto().getPrecoVenda());
            stmt.setInt(6, venda.getProduto().getQuantidade());
            stmt.setDouble(7, venda.getPrecoTotal());
            stmt.setInt(8, venda.getId());
            stmt.executeUpdate();
            stmt.close();
            conexao.close();
            System.out.println("Venda atualizada com sucesso");

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public List<Venda> listar() {
        List<Venda> vendas = new ArrayList<>();

        try {
            PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM VENDA");
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                Venda venda = new Venda();
                Usuario usuario = new Usuario();
                Cliente cliente = new Cliente();
                Produto produto = new Produto();
                venda.setUsuario(usuario);
                venda.setCliente(cliente);
                venda.setProduto(produto);

                venda.setId(resultado.getInt("id"));
                venda.getUsuario().setNome(resultado.getString("usuario"));
                venda.getCliente().setNome(resultado.getString("cliente"));
                venda.setData(resultado.getString("data"));
                venda.getProduto().setNome(resultado.getString("produto"));
                venda.getProduto().setPrecoVenda(resultado.getDouble("precoVenda"));
                venda.getProduto().setQuantidade(resultado.getInt("quantidade"));
                venda.setPrecoTotal(resultado.getDouble("precoTotal"));

                vendas.add(venda);
            }
            stmt.close();
            resultado.close();
            conexao.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return vendas;
    }

    public void remover(int id) {
        try {
            PreparedStatement stmt = conexao.prepareStatement("DELETE FROM venda WHERE id=?");
            stmt.setInt(1, id);
            stmt.executeUpdate();
            stmt.close();
            conexao.close();
            System.out.println("Venda removida com sucesso");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Venda buscar(int id) {

        try {
            Venda venda = new Venda();
            Usuario usuario = new Usuario();
            Cliente cliente = new Cliente();
            Produto produto = new Produto();
            venda.setUsuario(usuario);
            venda.setCliente(cliente);
            venda.setProduto(produto);

            PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM venda WHERE id=?");
            stmt.setInt(1, id);
            ResultSet resultado = stmt.executeQuery();

            resultado.next();
            venda.setId(resultado.getInt("id"));
            venda.getUsuario().setNome(resultado.getString("usuario"));
            venda.getCliente().setNome(resultado.getString("cliente"));
            venda.setData(resultado.getString("data"));
            venda.getProduto().setNome(resultado.getString("produto"));
            venda.getProduto().setPrecoVenda(resultado.getDouble("precoVenda"));
            venda.getProduto().setQuantidade(resultado.getInt("quantidade"));
            venda.setPrecoTotal(resultado.getDouble("precoTotal"));
            stmt.close();
            resultado.close();
            conexao.close();
            return venda;

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao buscar a venda", ex);
        }

    }
}

