package com.joaovictor.cursomc.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.joaovictor.cursomc.domain.Categoria;
import com.joaovictor.cursomc.domain.Cidade;
import com.joaovictor.cursomc.domain.Cliente;
import com.joaovictor.cursomc.domain.Endereco;
import com.joaovictor.cursomc.domain.Estado;
import com.joaovictor.cursomc.domain.ItemPedido;
import com.joaovictor.cursomc.domain.Opcao;
import com.joaovictor.cursomc.domain.Pagamento;
import com.joaovictor.cursomc.domain.PagamentoComBoleto;
import com.joaovictor.cursomc.domain.PagamentoComCartao;
import com.joaovictor.cursomc.domain.Pedido;
import com.joaovictor.cursomc.domain.Produto;
import com.joaovictor.cursomc.domain.TipoOpcao;
import com.joaovictor.cursomc.domain.enums.EstadoPagamento;
import com.joaovictor.cursomc.domain.enums.NivelCategoria;
import com.joaovictor.cursomc.domain.enums.Perfil;
import com.joaovictor.cursomc.domain.enums.TipoCliente;
import com.joaovictor.cursomc.repositories.CategoriaRepository;
import com.joaovictor.cursomc.repositories.CidadeRepository;
import com.joaovictor.cursomc.repositories.ClienteRepository;
import com.joaovictor.cursomc.repositories.EnderecoRepository;
import com.joaovictor.cursomc.repositories.EstadoRepository;
import com.joaovictor.cursomc.repositories.ItemPedidoRepository;
import com.joaovictor.cursomc.repositories.OpcaoRepository;
import com.joaovictor.cursomc.repositories.PagamentoRepository;
import com.joaovictor.cursomc.repositories.PedidoRepository;
import com.joaovictor.cursomc.repositories.ProdutoRepository;
import com.joaovictor.cursomc.repositories.TipoOpcaoRepository;

@Service
public class DBService {
	
	@Autowired
	private BCryptPasswordEncoder pe;
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private PagamentoRepository pagamentoRepository;
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	@Autowired
	private TipoOpcaoRepository tipoOpcaoRepository;
	@Autowired
	private OpcaoRepository opcaoRepository;
	
	@Autowired
	private ProdutoService produtoService;
	
	public void instanciateTestDataBase() throws ParseException {
		Categoria cat1 = new Categoria(null, "Informática", NivelCategoria.PRIMEIRONIVEL);
		Categoria cat2 = new Categoria(null, "Móveis", NivelCategoria.PRIMEIRONIVEL);
		Categoria cat3 = new Categoria(null, "Casa", NivelCategoria.PRIMEIRONIVEL);
		Categoria cat4 = new Categoria(null, "Eletrodomésticos", NivelCategoria.PRIMEIRONIVEL);
		Categoria cat5 = new Categoria(null, "Masculino", NivelCategoria.PRIMEIRONIVEL);
		Categoria cat6 = new Categoria(null, "Feminino", NivelCategoria.PRIMEIRONIVEL);
//		Categoria cat7 = new Categoria(null, "Cuidados pessoais");
		
		Categoria cat7 = new Categoria(null, "Periféricos", NivelCategoria.SEGUNDONIVEL, cat1);
		Categoria cat8 = new Categoria(null, "Escritório", NivelCategoria.SEGUNDONIVEL, cat2);
		Categoria cat9 = new Categoria(null, "Utilides do lar", NivelCategoria.SEGUNDONIVEL, cat3);
		Categoria cat10 = new Categoria(null, "TV's", NivelCategoria.SEGUNDONIVEL, cat4);
		Categoria cat11 = new Categoria(null, "Moda", NivelCategoria.SEGUNDONIVEL, cat5);
		Categoria cat12 = new Categoria(null, "Calçado", NivelCategoria.SEGUNDONIVEL, cat5);
		Categoria cat13 = new Categoria(null, "Moda", NivelCategoria.SEGUNDONIVEL, cat6);
		Categoria cat14 = new Categoria(null, "Calçado", NivelCategoria.SEGUNDONIVEL, cat6);
		Categoria cat15 = new Categoria(null, "Computadores e notebooks", NivelCategoria.SEGUNDONIVEL, cat1);
		
		Categoria cat16 = new Categoria(null, "Mouses", NivelCategoria.TERCEIRONIVEL, cat7);
		Categoria cat17 = new Categoria(null, "Mesas e escrivanias", NivelCategoria.TERCEIRONIVEL, cat8);		
		Categoria cat18 = new Categoria(null, "Quarto e cama", NivelCategoria.TERCEIRONIVEL, cat9);
		Categoria cat19 = new Categoria(null, "Cozinha", NivelCategoria.TERCEIRONIVEL, cat9);
		Categoria cat20 = new Categoria(null, "Jardinagem", NivelCategoria.TERCEIRONIVEL, cat9);
		Categoria cat21 = new Categoria(null, "Decoração", NivelCategoria.TERCEIRONIVEL, cat9);
		Categoria cat22 = new Categoria(null, "Banho", NivelCategoria.TERCEIRONIVEL, cat9);
		Categoria cat23 = new Categoria(null, "Smart tv", NivelCategoria.TERCEIRONIVEL, cat10);
		Categoria cat24 = new Categoria(null, "Camisas e camisetas", NivelCategoria.TERCEIRONIVEL, cat11);
		Categoria cat25 = new Categoria(null, "Sapatênis", NivelCategoria.TERCEIRONIVEL, cat12);
		Categoria cat26 = new Categoria(null, "Blusas e camisetas", NivelCategoria.TERCEIRONIVEL, cat13);
		Categoria cat27 = new Categoria(null, "Sapatênis", NivelCategoria.TERCEIRONIVEL, cat14);
		Categoria cat28 = new Categoria(null, "Sandálias", NivelCategoria.TERCEIRONIVEL, cat14);
		Categoria cat29 = new Categoria(null, "Computadores", NivelCategoria.TERCEIRONIVEL, cat15);
		
		Categoria cat30 = new Categoria(null, "Computadores gamers", NivelCategoria.QUARTONIVEL, cat29);
		Categoria cat31 = new Categoria(null, "Casual", NivelCategoria.QUARTONIVEL, cat24);
		Categoria cat32 = new Categoria(null, "Mesas", NivelCategoria.QUARTONIVEL, cat17);
		Categoria cat33 = new Categoria(null, "Mouses com fio", NivelCategoria.QUARTONIVEL, cat16);
		Categoria cat34 = new Categoria(null, "Led", NivelCategoria.QUARTONIVEL, cat23);
		Categoria cat35 = new Categoria(null, "Toalhas", NivelCategoria.QUARTONIVEL, cat22);
		Categoria cat36 = new Categoria(null, "Roupões", NivelCategoria.QUARTONIVEL, cat22);
		Categoria cat37 = new Categoria(null, "Panelas", NivelCategoria.QUARTONIVEL, cat19);
		Categoria cat38 = new Categoria(null, "Ferramentas", NivelCategoria.QUARTONIVEL, cat20);
		Categoria cat39 = new Categoria(null, "Iluminação", NivelCategoria.QUARTONIVEL, cat21);
		Categoria cat40 = new Categoria(null, "Colchas", NivelCategoria.QUARTONIVEL, cat18);
		Categoria cat42 = new Categoria(null, "Regata", NivelCategoria.QUARTONIVEL, cat24);
		Categoria cat43 = new Categoria(null, "Casual", NivelCategoria.QUARTONIVEL, cat25);
		Categoria cat44 = new Categoria(null, "Casual", NivelCategoria.QUARTONIVEL, cat26);
		Categoria cat45 = new Categoria(null, "Regata", NivelCategoria.QUARTONIVEL, cat26);
		Categoria cat46 = new Categoria(null, "Casual", NivelCategoria.QUARTONIVEL, cat27);
		Categoria cat47 = new Categoria(null, "Rasteira", NivelCategoria.QUARTONIVEL, cat28);
		
		
		Produto p1 = new Produto(null, "Computador gamer i7", 2000.00);
//		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		Produto p4 = new Produto(null, "Mesa de escritório", 300.00);
		Produto p5 = new Produto(null, "Toalha", 50.00);
		Produto p6 = new Produto(null, "Colcha", 200.00);
		Produto p7 = new Produto(null, "TV true color", 1200.00);
		Produto p8 = new Produto(null, "Roçadeira", 800.00);
		Produto p9 = new Produto(null, "Abajour", 100.00);
		Produto p10 = new Produto(null, "Luminária", 180.00);
//		Produto p11 = new Produto(null, "Shampoo", 90.00);
		Produto p12 = new Produto(null, "Camisa Regata Masculina", 10.00);
		Produto p13 = new Produto(null, "Sapatênis Casual Masculino", 10.00);
		Produto p14 = new Produto(null, "Blusa Feminina", 10.00);
		Produto p15 = new Produto(null, "Sapatilha Feminina", 10.00);
		Produto p16 = new Produto(null, "Produto 16", 10.00);
		Produto p17 = new Produto(null, "Produto 17", 10.00);
		Produto p18 = new Produto(null, "Produto 18", 10.00);
		Produto p19 = new Produto(null, "Produto 19", 10.00);
		Produto p20 = new Produto(null, "Produto 20", 10.00);
		Produto p21 = new Produto(null, "Produto 21", 10.00);
		Produto p22 = new Produto(null, "Produto 22", 10.00);
		Produto p23 = new Produto(null, "Produto 23", 10.00);
		Produto p24 = new Produto(null, "Produto 24", 10.00);
		Produto p25 = new Produto(null, "Produto 25", 10.00);
		Produto p26 = new Produto(null, "Produto 26", 10.00);
		Produto p27 = new Produto(null, "Produto 27", 10.00);
		Produto p28 = new Produto(null, "Produto 28", 10.00);
		Produto p29 = new Produto(null, "Produto 29", 10.00);
		Produto p30 = new Produto(null, "Produto 30", 10.00);
		Produto p31 = new Produto(null, "Produto 31", 10.00);
		Produto p32 = new Produto(null, "Produto 32", 10.00);
		Produto p33 = new Produto(null, "Produto 33", 10.00);
		Produto p34 = new Produto(null, "Produto 34", 10.00);
		Produto p35 = new Produto(null, "Produto 35", 10.00);
		Produto p36 = new Produto(null, "Produto 36", 10.00);
		Produto p37 = new Produto(null, "Produto 37", 10.00);
		Produto p38 = new Produto(null, "Produto 38", 10.00);
		Produto p39 = new Produto(null, "Produto 39", 10.00);
		Produto p40 = new Produto(null, "Produto 40", 10.00);
		Produto p41 = new Produto(null, "Produto 41", 10.00);
		Produto p42 = new Produto(null, "Produto 42", 10.00);
		Produto p43 = new Produto(null, "Produto 43", 10.00);
		Produto p44 = new Produto(null, "Produto 44", 10.00);
		Produto p45 = new Produto(null, "Produto 45", 10.00);
		Produto p46 = new Produto(null, "Produto 46", 10.00);
		Produto p47 = new Produto(null, "Produto 47", 10.00);
		Produto p48 = new Produto(null, "Produto 48", 10.00);
		Produto p49 = new Produto(null, "Produto 49", 10.00);
		Produto p50 = new Produto(null, "Produto 50", 10.00);
		
		p1.getCategorias().addAll(Arrays.asList(cat30));
//		p2.getCategorias().addAll(Arrays.asList(cat8));
		p3.getCategorias().addAll(Arrays.asList(cat33));
		p4.getCategorias().addAll(Arrays.asList(cat32));
		p5.getCategorias().addAll(Arrays.asList(cat35));
		p6.getCategorias().addAll(Arrays.asList(cat40));
		p7.getCategorias().addAll(Arrays.asList(cat34));
		p8.getCategorias().addAll(Arrays.asList(cat38));
		p9.getCategorias().addAll(Arrays.asList(cat39));
		p10.getCategorias().addAll(Arrays.asList(cat39));
//		p11.getCategorias().addAll(Arrays.asList(cat28));
		p12.getCategorias().add(cat42);
		p13.getCategorias().add(cat43);
		p14.getCategorias().add(cat44);
		p15.getCategorias().add(cat46);
		
		p16.getCategorias().add(cat46);
		p17.getCategorias().add(cat46);
		p18.getCategorias().add(cat46);
		p19.getCategorias().add(cat46);
		p20.getCategorias().add(cat46);
		p21.getCategorias().add(cat46);
		p22.getCategorias().add(cat46);
		p23.getCategorias().add(cat46);
		p24.getCategorias().add(cat46);
		p25.getCategorias().add(cat46);
		p26.getCategorias().add(cat46);
		p27.getCategorias().add(cat46);
		p28.getCategorias().add(cat46);
		p29.getCategorias().add(cat46);
		p30.getCategorias().add(cat46);
		p31.getCategorias().add(cat46);
		p32.getCategorias().add(cat46);
		p33.getCategorias().add(cat46);
		p34.getCategorias().add(cat46);
		p35.getCategorias().add(cat46);
		p36.getCategorias().add(cat46);
		p37.getCategorias().add(cat46);
		p38.getCategorias().add(cat46);
		p39.getCategorias().add(cat46);
		p40.getCategorias().add(cat46);
		p41.getCategorias().add(cat46);
		p42.getCategorias().add(cat46);
		p43.getCategorias().add(cat46);
		p44.getCategorias().add(cat46);
		p45.getCategorias().add(cat46);
		p46.getCategorias().add(cat46);
		p47.getCategorias().add(cat46);
		p48.getCategorias().add(cat46);
		p49.getCategorias().add(cat46);
		p50.getCategorias().add(cat46);

		
//		cat8.getProdutos().addAll(Arrays.asList(p2, p3, p16, p17, p18, p19, p20,
//				p21, p22, p23, p24, p25, p26, p27, p28, p29, p30, p31, p32, p34, p35, p36, p37, p38,
//				p39, p40, p41, p42, p43, p44, p45, p46, p47, p48, p49, p50));
//		cat10.getProdutos().addAll(Arrays.asList(p4));
//		cat11.getProdutos().addAll(Arrays.asList(p9, p10));
//		cat12.getProdutos().addAll(Arrays.asList(p6, p9, p10));
//		cat14.getProdutos().addAll(Arrays.asList(p8));
//		cat17.getProdutos().addAll(Arrays.asList(p7));
//		cat19.getProdutos().addAll(Arrays.asList(p12));
//		cat21.getProdutos().addAll(Arrays.asList(p13));
//		cat23.getProdutos().addAll(Arrays.asList(p14));
//		cat25.getProdutos().addAll(Arrays.asList(p15));
//		cat27.getProdutos().addAll(Arrays.asList(p1));
//		cat28.getProdutos().addAll(Arrays.asList(p5, p11));
//		
//		
//		cat2.getProdutos().addAll(Arrays.asList(p2, p4));
//		cat3.getProdutos().addAll(Arrays.asList(p5, p6));
//		cat4.getProdutos().addAll(Arrays.asList(p1, p2, p3, p7));
//		cat5.getProdutos().addAll(Arrays.asList(p8));
//		cat6.getProdutos().addAll(Arrays.asList(p9, p10));
//		
//		cat7.getProdutos().addAll(Arrays.asList(p11));

//		p1.getCategorias().addAll(Arrays.asList(cat1, cat4));
//		p2.getCategorias().addAll(Arrays.asList(cat1, cat2, cat4));
//		p3.getCategorias().addAll(Arrays.asList(cat1, cat4));
				
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7, cat8,
				cat9, cat10, cat11, cat12, cat13, cat14, cat15, cat16, cat17, cat18,
				cat19, cat20, cat21, cat22, cat23, cat24, cat25, cat26, cat27, cat28, cat29, cat30
				, cat31, cat32, cat33, cat34, cat35, cat36, cat37, cat38, cat39, cat40, cat42
				, cat43, cat44, cat45, cat46, cat47));
		
//		produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11));
//		produtoRepository.saveAll(Arrays.asList(p12, p13, p14, p15, p16, p17, p18, p19, p20,
//				p21, p22, p23, p24, p25, p26, p27, p28, p29, p30, p31, p32, p33, p34, p35, p36, p37, p38,
//				p39, p40, p41, p42, p43, p44, p45, p46, p47, p48, p49, p50));
		

		produtoService.insert(p1);
		produtoService.insert(p3);
		produtoService.insert(p4);
		produtoService.insert(p5);
		produtoService.insert(p6);
		produtoService.insert(p7);
		produtoService.insert(p8);
		produtoService.insert(p9);
		produtoService.insert(p10);
		produtoService.insert(p12);
		produtoService.insert(p13);
		produtoService.insert(p14);
		produtoService.insert(p15);
		produtoService.insert(p16);
		produtoService.insert(p17);
		produtoService.insert(p18);
		produtoService.insert(p19);
		produtoService.insert(p20);
		produtoService.insert(p21);
		produtoService.insert(p22);
		produtoService.insert(p23);
		produtoService.insert(p24);
		produtoService.insert(p25);
		produtoService.insert(p26);
		produtoService.insert(p27);
		produtoService.insert(p28);
		produtoService.insert(p29);
		produtoService.insert(p30);
		produtoService.insert(p31);
		produtoService.insert(p32);
		produtoService.insert(p33);
		produtoService.insert(p34);
		produtoService.insert(p35);
		produtoService.insert(p36);
		produtoService.insert(p37);
		produtoService.insert(p38);
		produtoService.insert(p39);
		produtoService.insert(p40);
		produtoService.insert(p41);
		produtoService.insert(p42);
		produtoService.insert(p43);
		produtoService.insert(p44);
		produtoService.insert(p45);
		produtoService.insert(p46);
		produtoService.insert(p47);
		produtoService.insert(p48);
		produtoService.insert(p49);
		produtoService.insert(p50);
	
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
	
		Cliente cli1 = new Cliente(null, "Maria Silva", "teste@gmail.com", "48392972074", TipoCliente.PESSOAFISICA, pe.encode("123"));
		cli1.getTelefones().addAll(Arrays.asList("27363323", "93838393"));
		
		Cliente cli2 = new Cliente(null, "Ana Costa", "teste2@gmail.com", "23302591071", TipoCliente.PESSOAFISICA, pe.encode("123"));
		cli2.getTelefones().addAll(Arrays.asList("93883321", "34252625"));
		cli2.addPerfil(Perfil.ADMIN);
		
		Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 303", "Jardim", "38220834", cli1, c1);
		Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012", cli1, c2);
		Endereco e3 = new Endereco(null, "Avenida Floriano", "2106", null, "Centro", "281777012", cli2, c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		cli2.getEnderecos().addAll(Arrays.asList(e3));
	
		clienteRepository.saveAll(Arrays.asList(cli1, cli2));
		enderecoRepository.saveAll(Arrays.asList(e1, e2, e3));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), cli1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 19:35"), cli1, e2);
		
		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);
		
		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"), null);
		ped2.setPagamento(pagto2);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));
		
		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));
		
		ItemPedido ip1 = new ItemPedido(ped1, p1, 0.00, 1, 2000.00);
		ItemPedido ip2 = new ItemPedido(ped1, p3, 0.00, 2, 80.00);
		ItemPedido ip3 = new ItemPedido(ped2, p4, 100.00, 1, 800.00);
		
		ped1.getItens().addAll(Arrays.asList(ip1, ip2));
		ped2.getItens().addAll(Arrays.asList(ip3));
		
		p1.getItens().addAll(Arrays.asList(ip1));
		p4.getItens().addAll(Arrays.asList(ip3));
		p3.getItens().addAll(Arrays.asList(ip2));
		
		itemPedidoRepository.saveAll(Arrays.asList(ip1, ip2, ip3));
		
		
		// TipoOpcao e Opcao
		TipoOpcao tipoOpcao1 = new TipoOpcao(null, "Cor");
		TipoOpcao tipoOpcao2 = new TipoOpcao(null, "Tamanho");
		TipoOpcao tipoOpcao3 = new TipoOpcao(null, "Voltagem");
		
		Opcao opcao1 = new Opcao(null, "Azul", tipoOpcao1);
		Opcao opcao2 = new Opcao(null, "Vermelho", tipoOpcao1);
		Opcao opcao3 = new Opcao(null, "Preto", tipoOpcao1);
		Opcao opcao4 = new Opcao(null, "Amarelo", tipoOpcao1);
		
		Opcao opcao5 = new Opcao(null, "P", tipoOpcao2);
		Opcao opcao6 = new Opcao(null, "PP", tipoOpcao2);
		Opcao opcao7 = new Opcao(null, "M", tipoOpcao2);
		Opcao opcao8 = new Opcao(null, "G", tipoOpcao2);
		Opcao opcao9 = new Opcao(null, "GG", tipoOpcao2);
		
		Opcao opcao10 = new Opcao(null, "110V", tipoOpcao3);
		Opcao opcao11 = new Opcao(null, "220V", tipoOpcao3);
		Opcao opcao12 = new Opcao(null, "Bivolt", tipoOpcao3);
		
		tipoOpcao1.setOpcoes(Arrays.asList(opcao1, opcao2, opcao3, opcao4));
		tipoOpcao2.setOpcoes(Arrays.asList(opcao5, opcao6, opcao7, opcao8, opcao9));
		tipoOpcao3.setOpcoes(Arrays.asList(opcao10, opcao11, opcao12));
		
		tipoOpcaoRepository.saveAll(Arrays.asList(tipoOpcao1, tipoOpcao2, tipoOpcao3));
		opcaoRepository.saveAll(Arrays.asList(opcao1, opcao2, opcao3, opcao4, opcao5, opcao6, opcao7, opcao8, opcao9, opcao10, opcao11, opcao12));
	}
}
