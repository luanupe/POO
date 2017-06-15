
package br.com.distribuidora.negocios;

import br.com.distribuidora.entidades.Cliente;
import br.com.distribuidora.persistencia.RepositorioCliente;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


/**
 *
 * @author Patricia
 */
@Service
public class CadastrarClienteImp implements CadastrarCliente{
    
    private static final Logger log = LoggerFactory.getLogger(CadastrarClienteImp.class);
    
    @Autowired
    private RepositorioCliente repositorioCliente;
    
    @Override
    @Transactional(rollbackFor = ClienteExistenteException.class)
    public void adicionarCliente(Cliente cliente)throws ClienteExistenteException{
        try{
            this.buscarCliente(cliente.getCpfCnpj());
            this.log.error("Cliente " + cliente.getCpfCnpj()+ " já existe.");
            
            // ends
            throw new ClienteExistenteException("Cliente " + cliente.getCpfCnpj()+ " já existe.");
        }catch (ClienteInexistenteException e){
            this.repositorioCliente.save(cliente);
            this.log.info("Cliente " + cliente.getCpfCnpj()+ " cadastrado com sucesso.");
        }
    }
    
    @Override
    @Transactional(rollbackFor = ClienteInexistenteException.class)
    public Cliente buscarCliente(String cpfCnpf) throws ClienteInexistenteException {
        Cliente cliente = this.repositorioCliente.findByCpfCnpj(cpfCnpf);
        if ((cliente == null)) {
            throw new ClienteInexistenteException("Cliente " + cpfCnpf + " não existe.");
        }
        return cliente;
    }
    
    
    @Override
    @Transactional(rollbackFor = ClienteInexistenteException.class)
    public void atualizarCliente(Cliente cliente) throws ClienteInexistenteException {
       
        
       Cliente clienteAntigo = buscarCliente(cliente.getCpfCnpj());
       
       clienteAntigo.setEmail(cliente.getEmail());
       clienteAntigo.setEndereco(cliente.getEndereco());
       clienteAntigo.setNome(cliente.getNome());
       clienteAntigo.setTelefone(cliente.getTelefone());
       
       repositorioCliente.save(clienteAntigo);

    }
}
