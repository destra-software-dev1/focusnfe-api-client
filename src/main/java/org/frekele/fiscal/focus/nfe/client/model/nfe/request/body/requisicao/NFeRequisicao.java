package org.frekele.fiscal.focus.nfe.client.model.nfe.request.body.requisicao;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.frekele.fiscal.focus.nfe.client.converter.BigDecimalJsonConverter;
import org.frekele.fiscal.focus.nfe.client.converter.LocalDateJsonConverter;
import org.frekele.fiscal.focus.nfe.client.converter.OffsetDateTimeJsonConverter;
import org.frekele.fiscal.focus.nfe.client.core.FocusNFeEntity;
import org.frekele.fiscal.focus.nfe.client.enumeration.NFeCodigoRegimeEspecialTributacaoEnum;
import org.frekele.fiscal.focus.nfe.client.enumeration.NFeConsumidorFinalEnum;
import org.frekele.fiscal.focus.nfe.client.enumeration.NFeFinalidadeEmissaoEnum;
import org.frekele.fiscal.focus.nfe.client.enumeration.NFeIndicadorInscricaoEstadualDestinatarioEnum;
import org.frekele.fiscal.focus.nfe.client.enumeration.NFeLocalDestinoEnum;
import org.frekele.fiscal.focus.nfe.client.enumeration.NFeModalidadeFreteEnum;
import org.frekele.fiscal.focus.nfe.client.enumeration.NFePresencaCompradorEnum;
import org.frekele.fiscal.focus.nfe.client.enumeration.NFeRegimeTributarioEmitenteEnum;
import org.frekele.fiscal.focus.nfe.client.enumeration.NFeTipoDocumentoEnum;
import org.frekele.fiscal.focus.nfe.client.enumeration.NFeUnidadeFederativaEnum;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.List;

/**
 * @author frekele - Leandro Kersting de Freitas
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class NFeRequisicao implements FocusNFeEntity {

    private static final long serialVersionUID = 1L;

    //Descrição da natureza de operação.
    @NotNull
    @Size(min = 1, max = 60)
    @JsonProperty("natureza_operacao")
    private String naturezaOperacao;

    //Série da nota fiscal. Deixe em branco para que a API se responsabilize pela numeração automática (recomendado).
    @Size(min = 1, max = 3)
    @JsonProperty("serie")
    private String serie;

    //Número da nota fiscal. Deixe em branco para que a API se responsabilize pela numeração automática (recomendado)
    @Size(min = 1, max = 9)
    @JsonProperty("numero")
    private String numero;

    //Data e hora de emissão da emissão da NFe.
    //Formato padrão ISO, exemplo: “2016-12-25T12:00-0300”.
    @NotNull
    @OffsetDateTimeJsonConverter
    @JsonProperty("data_emissao")
    private OffsetDateTime dataEmissao;

    //Data e hora de entrada (em notas de entrada) ou saída (em notas de saída)
    //Formato padrão ISO, exemplo: “2016-12-25T12:00-0300”.
    @OffsetDateTimeJsonConverter
    @JsonProperty("data_entrada_saida")
    private OffsetDateTime dataEntradaSaida;

    //Tipo da NFe.
    @NotNull
    @JsonProperty("tipo_documento")
    private NFeTipoDocumentoEnum tipoDocumento;

    //Local onde a operação irá acontecer.
    @NotNull
    @JsonProperty("local_destino")
    private NFeLocalDestinoEnum localDestino;

    //Indicar qual a finalidade da emissão da nota.
    @NotNull
    @JsonProperty("finalidade_emissao")
    private NFeFinalidadeEmissaoEnum finalidadeEmissao;

    //Indicar se a operação é com consumidor final.
    @NotNull
    @JsonProperty("consumidor_final")
    private NFeConsumidorFinalEnum consumidorFinal;

    //Informar como foi a presença do comprador.
    @NotNull
    @JsonProperty("presenca_comprador")
    private NFePresencaCompradorEnum presencaComprador;

    //
    // Notas referenciadas.
    //
    @Size(max = 500)
    @JsonProperty("notas_referenciadas")
    private List<NFeNotaReferenciada> notasReferenciadas;

    //
    //Emitente:
    //
    //CNPJ da empresa emitente.
    @NotNull
    @Size(max = 14)
    @JsonProperty("cnpj_emitente")
    private String cnpjEmitente;

    //Razão social da empresa emitente.
    @Size(min = 2, max = 60)
    @JsonProperty("nome_emitente")
    private String nomeEmitente;

    //Nome fantasia da empresa emitente.
    @Size(min = 1, max = 60)
    @JsonProperty("nome_fantasia_emitente")
    private String nomeFantasiaEmitente;

    //Logradouro (rua, avenida, travessa etc.) da empresa emitente.
    @NotNull
    @Size(min = 2, max = 60)
    @JsonProperty("logradouro_emitente")
    private String logradouroEmitente;

    //Número do endereço da empresa emitente.
    @NotNull
    @Size(min = 1, max = 60)
    @JsonProperty("numero_emitente")
    private String numeroEmitente;

    //Complemento do endereço da empresa emitente.
    @Size(min = 1, max = 60)
    @JsonProperty("complemento_emitente")
    private String complementoEmitente;

    //Bairro da empresa emitente.
    @NotNull
    @Size(min = 2, max = 60)
    @JsonProperty("bairro_emitente")
    private String bairroEmitente;

    //Município da empresa emitente.
    @NotNull
    @Size(min = 2, max = 60)
    @JsonProperty("municipio_emitente")
    private String municipioEmitente;

    //UF da empresa emitente.
    @NotNull
    @JsonProperty("uf_emitente")
    private NFeUnidadeFederativaEnum ufEmitente;

    //CEP da empresa emitente.
    @Size(max = 8)
    @JsonProperty("cep_emitente")
    private String cepEmitente;

    //Telefone da empresa emitente.
    @JsonProperty("telefone_emitente")
    @Size(min = 6, max = 14)
    private String telefoneEmitente;

    //Inscrição Estadual da empresa emitente.
    @NotNull
    @Size(min = 2, max = 14)
    @JsonProperty("inscricao_estadual_emitente")
    private String inscricaoEstadualEmitente;

    //Inscrição Estadual do Substituto Tributário da empresa emitente.
    @Size(min = 2, max = 14)
    @JsonProperty("inscricao_estadual_st_emitente")
    private String inscricaoEstadualStEmitente;

    //Inscrição Municipal da empresa emitente. Se este campo for informado também deverá ser informado o CNAE Fiscal do emitente.
    @Size(min = 2, max = 15)
    @JsonProperty("inscricao_municipal_emitente")
    private String inscricaoMunicipalEmitente;

    //CNAE Fiscal da empresa emitente. Se este campo for informado também deverá ser informada a Inscrição Municipal do emitente.
    @Size(max = 7)
    @JsonProperty("cnae_fiscal_emitente")
    private String cnaeFiscalEmitente;

    //Informar qual o regime tributário do emitente.
    @NotNull
    @JsonProperty("regime_tributario_emitente")
    private NFeRegimeTributarioEmitenteEnum regimeTributarioEmitente;

    //
    //Destinatário:
    //
    //CNPJ da empresa destinatária.
    @NotNull
    @Size(max = 14)
    @JsonProperty("cnpj_destinatario")
    private String cnpjDestinatario;

    //CPF do destinatário. Caso utilize este campo, não enviar o campo “cnpf_destinatario”.
    @NotNull
    @Size(max = 11)
    @JsonProperty("cpf_destinatario")
    private String cpfDestinatario;

    //Identificação do destinatário no caso de comprador estrangeiro.
    @Size(min = 5, max = 20)
    @JsonProperty("id_estrangeiro_destinatario")
    private String idEstrangeiroDestinatario;

    //Nome completo ou razão social do destinatário
    @NotNull
    @Size(min = 2, max = 60)
    @JsonProperty("nome_destinatario")
    private String nomeDestinatario;

    //Logradouro (rua, avenida, travessa etc.) do destinatário.
    @NotNull
    @Size(min = 2, max = 60)
    @JsonProperty("logradouro_destinatario")
    private String logradouroDestinatario;

    //Número do endereço do destinatário.
    @NotNull
    @Size(min = 1, max = 60)
    @JsonProperty("numero_destinatario")
    private String numeroDestinatario;

    //Complemento do endereço do destinatário.
    @Size(min = 1, max = 60)
    @JsonProperty("complemento_destinatario")
    private String complementoDestinatario;

    //Bairro do destinatário.
    @NotNull
    @Size(min = 2, max = 60)
    @JsonProperty("bairro_destinatario")
    private String bairroDestinatario;

    //Código do município do destinatário (7 dígitos), de acordo com a tabela do IBGE.
    //Se não informado o sistema tentará encontrar o código com base no nome do município e da UF.
    @Size(min = 7)
    @JsonProperty("codigo_municipio_destinatario")
    private String codigoMunicipioDestinatario;

    //Município do destinatário.
    @NotNull
    @Size(min = 2, max = 60)
    @JsonProperty("municipio_destinatario")
    private String municipioDestinatario;

    //UF do destinatário. Deve ser omitido em operações com o exterior.
    @NotNull
    @JsonProperty("uf_destinatario")
    private NFeUnidadeFederativaEnum ufDestinatario;

    //CEP do destinatário.
    @Size(max = 8)
    @JsonProperty("cep_destinatario")
    private String cepDestinatario;

    //Código IBGE do país do destinatário. (Apenas se diferente de 1058 - Brasil).
    @Size(min = 2, max = 4)
    @JsonProperty("codigo_pais_destinatario")
    private String codigoPaisDestinatario;

    //Nome do país do destinatário. (Apenas se diferente de Brasil).
    @Size(min = 2, max = 4)
    @JsonProperty("pais_destinatario")
    private String paisDestinatario;

    //Telefone do destinatário.
    @Size(min = 6, max = 14)
    @JsonProperty("telefone_destinatario")
    private String telefoneDestinatario;

    //Indicador da Inscrição Estadual do destinatário.
    @NotNull
    @JsonProperty("indicador_inscricao_estadual_destinatario")
    private NFeIndicadorInscricaoEstadualDestinatarioEnum indicadorInscricaoEstadualDestinatario;

    //Informar a Inscrição Estadual do destinatário.
    @Size(min = 2, max = 14)
    @JsonProperty("inscricao_estadual_destinatario")
    private String inscricaoEstadualDestinatario;

    //Inscrição Suframa do destinatário.
    @Size(min = 8, max = 9)
    @JsonProperty("inscricao_suframa_destinatario")
    private String inscricaoSuframaDestinatario;

    //Inscrição Municipal do Tomador do Serviço (apenas para NFe conjugada).
    @Size(min = 1, max = 15)
    @JsonProperty("inscricao_municipal_destinatario")
    private String inscricaoMunicipalDestinatario;

    //E-mail do destinatário.
    //O destinatário receberá um e-mail com o XML e a DANFE gerados, adicione mais de um email separando por vírgulas.
    //Será informado apenas o primeiro email no XML da NFe mas todos os emails informados receberão os arquivos.
    @Size(min = 1, max = 60)
    @JsonProperty("email_destinatario")
    private String emailDestinatario;

    //
    //Retirada:
    //
    //CNPJ do local de retirada. (Informar apenas quando o local de retirada for diferente do destinatário.)
    @Size(max = 14)
    @JsonProperty("cnpj_retirada")
    private String cnpjRetirada;

    //CPF do local de retirada. (Informar apenas quando o local de retirada for diferente do destinatário.)
    @Size(max = 11)
    @JsonProperty("cpf_retirada")
    private String cpfRetirada;

    //Logradouro do local de retirada. (Informar apenas quando o local de retirada for diferente do destinatário.)
    @Size(min = 2, max = 60)
    @JsonProperty("logradouro_retirada")
    private String logradouroRetirada;

    //Número do local de retirada. (Informar apenas quando o local de retirada for diferente do destinatário.)
    @Size(min = 1, max = 60)
    @JsonProperty("numero_retirada")
    private String numeroRetirada;

    //Complemento do local de retirada. (Informar apenas quando o local de retirada for diferente do destinatário.)
    @Size(min = 1, max = 60)
    @JsonProperty("complemento_retirada")
    private String complementoRetirada;

    //Bairro do local de retirada. (Informar apenas quando o local de retirada for diferente do destinatário.)
    @Size(min = 1, max = 60)
    @JsonProperty("bairro_retirada")
    private String bairroRetirada;

    //Código do município de retirada (7 dígitos), de acordo com a tabela do IBGE. Se não informado o sistema tentará encontrar o código com base no nome do município e da UF.
    @Size(max = 7)
    @JsonProperty("codigo_municipio_retirada")
    private String codigoMunicipioRetirada;

    //Município do local de retirada. (Informar apenas quando o local de retirada for diferente do destinatário.)
    @Size(min = 2, max = 60)
    @JsonProperty("municipio_retirada")
    private String municipioRetirada;

    //UF do local de retirada. (Informar apenas quando o local de retirada for diferente do destinatário.)
    @JsonProperty("uf_retirada")
    private NFeUnidadeFederativaEnum ufRetirada;

    //
    //Entrega:
    //
    //CNPJ do local de entrega. (Informar apenas quando o local de entrega for diferente do destinatário.)
    @Size(max = 14)
    @JsonProperty("cnpj_entrega")
    private String cnpjEntrega;

    //CPF do local de entrega. (Informar apenas quando o local de entrega for diferente do destinatário.)
    @Size(max = 11)
    @JsonProperty("cpf_entrega")
    private String cpfEntrega;

    //Logradouro do local de entrega. (Informar apenas quando o local de entrega for diferente do destinatário.)
    @Size(min = 2, max = 60)
    @JsonProperty("logradouro_entrega")
    private String logradouroEntrega;

    //Número do local de entrega. (Informar apenas quando o local de entrega for diferente do destinatário.)
    @Size(min = 1, max = 60)
    @JsonProperty("numero_entrega")
    private String numeroEntrega;

    //Complemento do local de entrega. (Informar apenas quando o local de entrega for diferente do destinatário.)
    @Size(min = 1, max = 60)
    @JsonProperty("complemento_entrega")
    private String complementoEntrega;

    //Bairro do local de entrega. (Informar apenas quando o local de entrega for diferente do destinatário.)
    @Size(min = 2, max = 60)
    @JsonProperty("bairro_entrega")
    private String bairroEntrega;

    //Código do município de entrega (7 dígitos), de acordo com a tabela do IBGE. Se não informado o sistema tentará encontrar o código com base no nome do município e da UF.
    @Size(max = 7)
    @JsonProperty("codigo_municipio_entrega")
    private String codigoMunicipioEntrega;

    //Município do local de entrega. (Informar apenas quando o local de entrega for diferente do destinatário.)
    @Size(min = 2, max = 60)
    @JsonProperty("municipio_entrega")
    private String municipioEntrega;

    //UF do local de entrega. (Informar apenas quando o local de entrega for diferente do destinatário.)
    @JsonProperty("uf_entrega")
    private NFeUnidadeFederativaEnum ufEntrega;

    //Pessoas autorizadas a acessar o XML da NF-e.
    @Size(max = 10)
    @JsonProperty("pessoas_autorizadas")
    private List<NFePessoaAutorizada> pessoasAutorizadas;

    //Uma NFe irá conter um ou mais itens no campo “items”.
    @Size(max = 990)
    @JsonProperty("items")
    private List<NFeItem> items;

    //Valor total da base de cálculo do ICMS. Calculado automaticamente se omitido.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("icms_base_calculo")
    private BigDecimal icmsBaseCalculo;

    //Valor total do ICMS. Calculado automaticamente se omitido.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("icms_valor_total")
    private BigDecimal icmsValorTotal;

    //Valor total do ICMS Desonerado. Calculado automaticamente se omitido.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("icms_valor_total_desonerado")
    private BigDecimal icmsValorTotalDesonerado;

    //(apenas para venda interestadual para consumidor final)
    //Valor total do ICMS relativo Fundo de Combate à Pobreza (FCP) da UF de destino. Calculado automaticamente se omitido.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("fcp_valor_total_uf_destino")
    private BigDecimal fcpValorTotalUfDestino;

    //(apenas para venda interestadual para consumidor final) Valor total do ICMS Interestadual para a UF de destino. Calculado automaticamente se omitido.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("icms_valor_total_uf_destino")
    private BigDecimal icmsValorTotalUfDestino;

    //(apenas para venda interestadual para consumidor final) Valor total do ICMS Interestadual para a UF do remetente. Calculado automaticamente se omitido.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("icms_valor_total_uf_remetente")
    private BigDecimal icmsValorTotalUfRemetente;

    //Valor Total do FCP (Fundo de Combate à Pobreza). Calculado automaticamente se omitido.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("fcp_valor_total")
    private BigDecimal fcpValorTotal;

    //Valor total da base de cálculo do ICMS do substituto tributário. Calculado automaticamente se omitido.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("icms_base_calculo_st")
    private BigDecimal icmsBaseCalculoSt;

    //Valor total do ICMS do substituto tributário. Calculado automaticamente se omitido.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("icms_valor_total_st")
    private BigDecimal icmsValorTotalSt;

    //Valor Total do FCP (Fundo de Combate à Pobreza) retido por substituição tributária. Calculado automaticamente se omitido.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("fcp_valor_total_st")
    private BigDecimal fcpValorTotalSt;

    //Valor Total do FCP (Fundo de Combate à Pobreza) retido anteriormente substituição tributária. Calculado automaticamente se omitido.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("fcp_valor_total_retido_st")
    private BigDecimal fcpValorTotalRetidoSt;

    //Valor total dos produtos. Calculado automaticamente se omitido.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("valor_produtos")
    private BigDecimal valorProdutos;

    //Valor total do frete. Calculado automaticamente se omitido.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("valor_frete")
    private BigDecimal valorFrete;

    //Valor total do seguro. Calculado automaticamente se omitido.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("valor_seguro")
    private BigDecimal valorSeguro;

    //Valor total do desconto. Calculado automaticamente se omitido.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("valor_desconto")
    private BigDecimal valorDesconto;

    //Valor total do imposto de importação. Calculado automaticamente se omitido.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("valor_total_ii")
    private BigDecimal valorTotalII;

    //Valor total do IPI. Calculado automaticamente se omitido.
    @Digits(integer = 13, fraction = 2)
    @JsonProperty("valor_ipi")
    private BigDecimal valorIpi;

    //Valor total do IPI devolvido. Calculado automaticamente se omitido.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("valor_ipi_devolvido")
    private BigDecimal valorIpiDevolvido;

    //Valor do PIS. Calculado automaticamente se omitido.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("valor_pis")
    private BigDecimal valorPis;

    //Valor do COFINS. Calculado automaticamente se omitido.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("valor_cofins")
    private BigDecimal valorCofins;

    //Valor das despesas acessórias. Calculado automaticamente se omitido.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("valor_outras_despesas")
    private BigDecimal valorOutrasDespesas;

    //Valor total da nota fiscal.
    //Se não informado o valor será calculado como:
    //(valor_produtos - valor_desconto - icms_valor_total_desonerado + icms_valor_total_st + valor_frete + valor_seguro + valor_outras_despesas + valor_total_ii + valor_ipi + valor_total_servicos).
    //Este campo não será calculado se a nota for de importação (CFOP começando com 3).
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("valor_total")
    private BigDecimal valorTotal;

    //Valor total aproximado dos tributos - calculado automaticamente pela API.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("valor_total_tributos")
    private BigDecimal valorTotalTributos;

    //(ISSQN) Valor Total dos Serviços sob não-incidência ou não tributados pelo ICMS.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("valor_total_servicos")
    private BigDecimal valorTotalServicos;

    //(ISSQN) Base de Cálculo do ISS.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("issqn_base_calculo")
    private BigDecimal issqnBaseCalculo;

    //(ISSQN) Valor Total do ISS.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("issqn_valor_total")
    private BigDecimal issqnValorTotal;

    //(ISSQN) Valor do PIS sobre serviços.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("valor_pis_servicos")
    private BigDecimal valorPisServicos;

    //(ISSQN) Valor do COFINS sobre serviços.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("valor_cofins_servicos")
    private BigDecimal valorCofinsServicos;

    //(ISSQN) Data da prestação do serviço. Obrigatório se houver serviços
    @LocalDateJsonConverter
    @JsonProperty("data_prestacao_servico")
    private LocalDate dataPrestacaoServico;

    //(ISSQN) Valor total da dedução para redução da Base de Cálculo
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("issqn_valor_total_deducao")
    private BigDecimal issqnValorTotalDeducao;

    //(ISSQN) Valor total outras retenções
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("issqn_valor_total_outras_retencoes")
    private BigDecimal issqnValorTotalOutrasRetencoes;

    //(ISSQN) Valor total desconto incondicionado
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("issqn_valor_total_desconto_incondicionado")
    private BigDecimal issqnValorTotalDescontoIncondicionado;

    //(ISSQN) Valor total desconto condicionado
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("issqn_valor_total_desconto_condicionado")
    private BigDecimal issqnValorTotalDescontoCondicionado;

    //(ISSQN) Valor total retenção ISS
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("issqn_valor_total_retencao")
    private BigDecimal issqnValorTotalRetencao;

    //(ISSQN) Código do regime especial de tributação
    @JsonProperty("codigo_regime_especial_tributacao")
    private NFeCodigoRegimeEspecialTributacaoEnum codigoRegimeEspecialTributacao;

    //Valor Retido de PIS.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("pis_valor_retido")
    private BigDecimal pisValorRetido;

    //Valor Retido de COFINS.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("cofins_valor_retido")
    private BigDecimal cofinsValorRetido;

    //Valor Retido de CSLL.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("csll_valor_retido")
    private BigDecimal csllValorRetido;

    //Base de Cálculo do IRRF.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("irrf_base_calculo")
    private BigDecimal irrfBaseCalculo;

    //Valor Retido de IRRF.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("irrf_valor_retido")
    private BigDecimal irrfValorRetido;

    //Base de Cálculo da Retenção da Previdêncica Social.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("prev_social_base_calculo")
    private BigDecimal prevSocialBaseCalculo;

    //Valor da Retenção da Previdêncica Social.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("prev_social_valor_retido")
    private BigDecimal prevSocialValorRetido;

    //Modalidade do frete.
    @NotNull
    @JsonProperty("modalidade_frete")
    private NFeModalidadeFreteEnum modalidadeFrete;

    //CNPJ do transportador. Se este campo for informado não deverá ser informado o CPF.
    @Size(max = 14)
    @JsonProperty("cnpj_transportador")
    private String cnpjTransportador;

    //CPF do transportador. Se este campo for informado não deverá ser informado o CNPJ.
    @Size(max = 11)
    @JsonProperty("cpf_transportador")
    private String cpfTransportador;

    //Nome ou razão social do transportador.
    @Size(min = 2, max = 60)
    @JsonProperty("nome_transportador")
    private String nomeTransportador;

    //Inscrição Estadual do transportador.
    @Size(min = 2, max = 14)
    @JsonProperty("inscricao_estadual_transportador")
    private String inscricaoEstadualTransportador;

    //Endereço (logradouro, número, complemento e bairro) do transportador.
    @Size(min = 1, max = 60)
    @JsonProperty("endereco_transportador")
    private String enderecoTransportador;

    //Município do transportador.
    @Size(min = 1, max = 60)
    @JsonProperty("municipio_transportador")
    private String municipioTransportador;

    //UF do transportador.
    @JsonProperty("uf_transportador")
    private NFeUnidadeFederativaEnum ufTransportador;

    //Valor do serviço de transporte.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("transporte_icms_servico")
    private BigDecimal transporteIcmsServico;

    //Base de cálculo da retenção do ICMS de transporte.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("transporte_icms_base_calculo")
    private BigDecimal transporteIcmsBaseCalculo;

    //Alíquota da retenção do ICMS de transporte.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("transporte_icms_aliquota")
    private BigDecimal transporteIcmsAliquota;

    //Valor retido do ICMS de transporte.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("transporte_icms_valor")
    private BigDecimal transporteIcmsValor;

    //CFOP do serviço de transporte.
    //(Valores aceitos: 5351, 5352, 5353, 5354, 5355, 5356, 5357, 5359, 5360, 5931, 5932, 6351, 6352, 6353, 6354, 6355, 6356, 6357, 6359, 6360, 6931, 6932, 7358)
    @Size(max = 4)
    @JsonProperty("transporte_icms_cfop")
    private String transporteIcmsCfop;

    //Código do município de ocorrência do fato gerador.
    @Size(max = 7)
    @JsonProperty("transporte_icms_codigo_municipio")
    private String transporteIcmsCodigoMunicipio;

    //Placa do veículo de transporte.
    @JsonProperty("veiculo_placa")
    private String veiculoPlaca;

    //UF do veículo de transporte.
    @JsonProperty("veiculo_uf")
    private NFeUnidadeFederativaEnum veiculoUf;

    //RNTC (Registro Nacional de Transportador de Carga - ANTT) do veículo de transporte.
    @JsonProperty("veiculo_rntc")
    private String veiculoRntc;

    //Reboques
    @Size(max = 5)
    @JsonProperty("reboques")
    private List<NFeReboque> reboques;

    //Identificação do vagão de transporte.
    @Size(min = 1, max = 20)
    @JsonProperty("veiculo_identificacao_vagao")
    private String veiculoIdentificacaoVagao;

    //Identificação da balsa de transporte.
    @Size(min = 1, max = 20)
    @JsonProperty("veiculo_identificacao_balsa")
    private String veiculoIdentificacaoBalsa;

    //Volumes transportados.
    @Size(max = 5000)
    @JsonProperty("volumes")
    private List<NFeVolumeTransportado> volumes;

    //Número da fatura.
    @Size(min = 1, max = 60)
    @JsonProperty("numero_fatura")
    private String numeroFatura;

    //Valor original da fatura.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("valor_original_fatura")
    private BigDecimal valorOriginalFatura;

    //Valor do desconto da fatura.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("valor_desconto_fatura")
    private BigDecimal valorDescontoFatura;

    //Valor líquido da fatura.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("valor_liquido_fatura")
    private BigDecimal valorLiquidoFatura;

    //Duplicatas da nota fiscal.
    @Size(max = 120)
    @JsonProperty("duplicatas")
    private List<NFeDuplicataNotaFiscal> duplicatas;

    //Formas de Pagamento (Tanto NF-e quanto NFC-e)
    @Size(max = 100)
    @JsonProperty("formas_pagamento")
    private List<NFeFormaPagamento> formasPagamento;

    //Informações adicionais de interesse do fisco.
    @Size(min = 1, max = 2000)
    @JsonProperty("informacoes_adicionais_fisco")
    private String informacoesAdicionaisFisco;

    //Informações adicionais de interesse do contribuinte.
    @Size(min = 1, max = 5000)
    @JsonProperty("informacoes_adicionais_contribuinte")
    private String informacoesAdicionaisContribuinte;

    //Sigla da UF de Embarque ou de transposição de fronteira
    @Size(max = 2)
    @JsonProperty("uf_local_embarque")
    private NFeUnidadeFederativaEnum ufLocalEmbarque;

    //Descrição do Local de Embarque ou de transposição de fronteira
    @Size(min = 1, max = 60)
    @JsonProperty("local_embarque")
    private String localEmbarque;

    //Descrição do local de despacho
    @Size(min = 1, max = 60)
    @JsonProperty("local_despacho")
    private String localDespacho;

    public NFeRequisicao() {
        super();
    }

    private NFeRequisicao(Builder builder) {
        setNaturezaOperacao(builder.naturezaOperacao);
        setSerie(builder.serie);
        setNumero(builder.numero);
        setDataEmissao(builder.dataEmissao);
        setDataEntradaSaida(builder.dataEntradaSaida);
        setTipoDocumento(builder.tipoDocumento);
        setLocalDestino(builder.localDestino);
        setFinalidadeEmissao(builder.finalidadeEmissao);
        setConsumidorFinal(builder.consumidorFinal);
        setPresencaComprador(builder.presencaComprador);
        setNotasReferenciadas(builder.notasReferenciadas);
        setCnpjEmitente(builder.cnpjEmitente);
        setNomeEmitente(builder.nomeEmitente);
        setNomeFantasiaEmitente(builder.nomeFantasiaEmitente);
        setLogradouroEmitente(builder.logradouroEmitente);
        setNumeroEmitente(builder.numeroEmitente);
        setComplementoEmitente(builder.complementoEmitente);
        setBairroEmitente(builder.bairroEmitente);
        setMunicipioEmitente(builder.municipioEmitente);
        setUfEmitente(builder.ufEmitente);
        setCepEmitente(builder.cepEmitente);
        setTelefoneEmitente(builder.telefoneEmitente);
        setInscricaoEstadualEmitente(builder.inscricaoEstadualEmitente);
        setInscricaoEstadualStEmitente(builder.inscricaoEstadualStEmitente);
        setInscricaoMunicipalEmitente(builder.inscricaoMunicipalEmitente);
        setCnaeFiscalEmitente(builder.cnaeFiscalEmitente);
        setRegimeTributarioEmitente(builder.regimeTributarioEmitente);
        setCnpjDestinatario(builder.cnpjDestinatario);
        setCpfDestinatario(builder.cpfDestinatario);
        setIdEstrangeiroDestinatario(builder.idEstrangeiroDestinatario);
        setNomeDestinatario(builder.nomeDestinatario);
        setLogradouroDestinatario(builder.logradouroDestinatario);
        setNumeroDestinatario(builder.numeroDestinatario);
        setComplementoDestinatario(builder.complementoDestinatario);
        setBairroDestinatario(builder.bairroDestinatario);
        setCodigoMunicipioDestinatario(builder.codigoMunicipioDestinatario);
        setMunicipioDestinatario(builder.municipioDestinatario);
        setUfDestinatario(builder.ufDestinatario);
        setCepDestinatario(builder.cepDestinatario);
        setCodigoPaisDestinatario(builder.codigoPaisDestinatario);
        setPaisDestinatario(builder.paisDestinatario);
        setTelefoneDestinatario(builder.telefoneDestinatario);
        setIndicadorInscricaoEstadualDestinatario(builder.indicadorInscricaoEstadualDestinatario);
        setInscricaoEstadualDestinatario(builder.inscricaoEstadualDestinatario);
        setInscricaoSuframaDestinatario(builder.inscricaoSuframaDestinatario);
        setInscricaoMunicipalDestinatario(builder.inscricaoMunicipalDestinatario);
        setEmailDestinatario(builder.emailDestinatario);
        setCnpjRetirada(builder.cnpjRetirada);
        setCpfRetirada(builder.cpfRetirada);
        setLogradouroRetirada(builder.logradouroRetirada);
        setNumeroRetirada(builder.numeroRetirada);
        setComplementoRetirada(builder.complementoRetirada);
        setBairroRetirada(builder.bairroRetirada);
        setCodigoMunicipioRetirada(builder.codigoMunicipioRetirada);
        setMunicipioRetirada(builder.municipioRetirada);
        setUfRetirada(builder.ufRetirada);
        setCnpjEntrega(builder.cnpjEntrega);
        setCpfEntrega(builder.cpfEntrega);
        setLogradouroEntrega(builder.logradouroEntrega);
        setNumeroEntrega(builder.numeroEntrega);
        setComplementoEntrega(builder.complementoEntrega);
        setBairroEntrega(builder.bairroEntrega);
        setCodigoMunicipioEntrega(builder.codigoMunicipioEntrega);
        setMunicipioEntrega(builder.municipioEntrega);
        setUfEntrega(builder.ufEntrega);
        setPessoasAutorizadas(builder.pessoasAutorizadas);
        setItems(builder.items);
        setIcmsBaseCalculo(builder.icmsBaseCalculo);
        setIcmsValorTotal(builder.icmsValorTotal);
        setIcmsValorTotalDesonerado(builder.icmsValorTotalDesonerado);
        setFcpValorTotalUfDestino(builder.fcpValorTotalUfDestino);
        setIcmsValorTotalUfDestino(builder.icmsValorTotalUfDestino);
        setIcmsValorTotalUfRemetente(builder.icmsValorTotalUfRemetente);
        setFcpValorTotal(builder.fcpValorTotal);
        setIcmsBaseCalculoSt(builder.icmsBaseCalculoSt);
        setIcmsValorTotalSt(builder.icmsValorTotalSt);
        setFcpValorTotalSt(builder.fcpValorTotalSt);
        setFcpValorTotalRetidoSt(builder.fcpValorTotalRetidoSt);
        setValorProdutos(builder.valorProdutos);
        setValorFrete(builder.valorFrete);
        setValorSeguro(builder.valorSeguro);
        setValorDesconto(builder.valorDesconto);
        setValorTotalII(builder.valorTotalII);
        setValorIpi(builder.valorIpi);
        setValorIpiDevolvido(builder.valorIpiDevolvido);
        setValorPis(builder.valorPis);
        setValorCofins(builder.valorCofins);
        setValorOutrasDespesas(builder.valorOutrasDespesas);
        setValorTotal(builder.valorTotal);
        setValorTotalTributos(builder.valorTotalTributos);
        setValorTotalServicos(builder.valorTotalServicos);
        setIssqnBaseCalculo(builder.issqnBaseCalculo);
        setIssqnValorTotal(builder.issqnValorTotal);
        setValorPisServicos(builder.valorPisServicos);
        setValorCofinsServicos(builder.valorCofinsServicos);
        setDataPrestacaoServico(builder.dataPrestacaoServico);
        setIssqnValorTotalDeducao(builder.issqnValorTotalDeducao);
        setIssqnValorTotalOutrasRetencoes(builder.issqnValorTotalOutrasRetencoes);
        setIssqnValorTotalDescontoIncondicionado(builder.issqnValorTotalDescontoIncondicionado);
        setIssqnValorTotalDescontoCondicionado(builder.issqnValorTotalDescontoCondicionado);
        setIssqnValorTotalRetencao(builder.issqnValorTotalRetencao);
        setCodigoRegimeEspecialTributacao(builder.codigoRegimeEspecialTributacao);
        setPisValorRetido(builder.pisValorRetido);
        setCofinsValorRetido(builder.cofinsValorRetido);
        setCsllValorRetido(builder.csllValorRetido);
        setIrrfBaseCalculo(builder.irrfBaseCalculo);
        setIrrfValorRetido(builder.irrfValorRetido);
        setPrevSocialBaseCalculo(builder.prevSocialBaseCalculo);
        setPrevSocialValorRetido(builder.prevSocialValorRetido);
        setModalidadeFrete(builder.modalidadeFrete);
        setCnpjTransportador(builder.cnpjTransportador);
        setCpfTransportador(builder.cpfTransportador);
        setNomeTransportador(builder.nomeTransportador);
        setInscricaoEstadualTransportador(builder.inscricaoEstadualTransportador);
        setEnderecoTransportador(builder.enderecoTransportador);
        setMunicipioTransportador(builder.municipioTransportador);
        setUfTransportador(builder.ufTransportador);
        setTransporteIcmsServico(builder.transporteIcmsServico);
        setTransporteIcmsBaseCalculo(builder.transporteIcmsBaseCalculo);
        setTransporteIcmsAliquota(builder.transporteIcmsAliquota);
        setTransporteIcmsValor(builder.transporteIcmsValor);
        setTransporteIcmsCfop(builder.transporteIcmsCfop);
        setTransporteIcmsCodigoMunicipio(builder.transporteIcmsCodigoMunicipio);
        setVeiculoPlaca(builder.veiculoPlaca);
        setVeiculoUf(builder.veiculoUf);
        setVeiculoRntc(builder.veiculoRntc);
        setReboques(builder.reboques);
        setVeiculoIdentificacaoVagao(builder.veiculoIdentificacaoVagao);
        setVeiculoIdentificacaoBalsa(builder.veiculoIdentificacaoBalsa);
        setVolumes(builder.volumes);
        setNumeroFatura(builder.numeroFatura);
        setValorOriginalFatura(builder.valorOriginalFatura);
        setValorDescontoFatura(builder.valorDescontoFatura);
        setValorLiquidoFatura(builder.valorLiquidoFatura);
        setDuplicatas(builder.duplicatas);
        setFormasPagamento(builder.formasPagamento);
        setInformacoesAdicionaisFisco(builder.informacoesAdicionaisFisco);
        setInformacoesAdicionaisContribuinte(builder.informacoesAdicionaisContribuinte);
        setUfLocalEmbarque(builder.ufLocalEmbarque);
        setLocalEmbarque(builder.localEmbarque);
        setLocalDespacho(builder.localDespacho);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getNaturezaOperacao() {
        return naturezaOperacao;
    }

    public void setNaturezaOperacao(String naturezaOperacao) {
        this.naturezaOperacao = naturezaOperacao;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public OffsetDateTime getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(OffsetDateTime dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public OffsetDateTime getDataEntradaSaida() {
        return dataEntradaSaida;
    }

    public void setDataEntradaSaida(OffsetDateTime dataEntradaSaida) {
        this.dataEntradaSaida = dataEntradaSaida;
    }

    public NFeTipoDocumentoEnum getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(NFeTipoDocumentoEnum tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public NFeLocalDestinoEnum getLocalDestino() {
        return localDestino;
    }

    public void setLocalDestino(NFeLocalDestinoEnum localDestino) {
        this.localDestino = localDestino;
    }

    public NFeFinalidadeEmissaoEnum getFinalidadeEmissao() {
        return finalidadeEmissao;
    }

    public void setFinalidadeEmissao(NFeFinalidadeEmissaoEnum finalidadeEmissao) {
        this.finalidadeEmissao = finalidadeEmissao;
    }

    public NFeConsumidorFinalEnum getConsumidorFinal() {
        return consumidorFinal;
    }

    public void setConsumidorFinal(NFeConsumidorFinalEnum consumidorFinal) {
        this.consumidorFinal = consumidorFinal;
    }

    public NFePresencaCompradorEnum getPresencaComprador() {
        return presencaComprador;
    }

    public void setPresencaComprador(NFePresencaCompradorEnum presencaComprador) {
        this.presencaComprador = presencaComprador;
    }

    public List<NFeNotaReferenciada> getNotasReferenciadas() {
        return notasReferenciadas;
    }

    public void setNotasReferenciadas(List<NFeNotaReferenciada> notasReferenciadas) {
        this.notasReferenciadas = notasReferenciadas;
    }

    public String getCnpjEmitente() {
        return cnpjEmitente;
    }

    public void setCnpjEmitente(String cnpjEmitente) {
        this.cnpjEmitente = cnpjEmitente;
    }

    public String getNomeEmitente() {
        return nomeEmitente;
    }

    public void setNomeEmitente(String nomeEmitente) {
        this.nomeEmitente = nomeEmitente;
    }

    public String getNomeFantasiaEmitente() {
        return nomeFantasiaEmitente;
    }

    public void setNomeFantasiaEmitente(String nomeFantasiaEmitente) {
        this.nomeFantasiaEmitente = nomeFantasiaEmitente;
    }

    public String getLogradouroEmitente() {
        return logradouroEmitente;
    }

    public void setLogradouroEmitente(String logradouroEmitente) {
        this.logradouroEmitente = logradouroEmitente;
    }

    public String getNumeroEmitente() {
        return numeroEmitente;
    }

    public void setNumeroEmitente(String numeroEmitente) {
        this.numeroEmitente = numeroEmitente;
    }

    public String getComplementoEmitente() {
        return complementoEmitente;
    }

    public void setComplementoEmitente(String complementoEmitente) {
        this.complementoEmitente = complementoEmitente;
    }

    public String getBairroEmitente() {
        return bairroEmitente;
    }

    public void setBairroEmitente(String bairroEmitente) {
        this.bairroEmitente = bairroEmitente;
    }

    public String getMunicipioEmitente() {
        return municipioEmitente;
    }

    public void setMunicipioEmitente(String municipioEmitente) {
        this.municipioEmitente = municipioEmitente;
    }

    public NFeUnidadeFederativaEnum getUfEmitente() {
        return ufEmitente;
    }

    public void setUfEmitente(NFeUnidadeFederativaEnum ufEmitente) {
        this.ufEmitente = ufEmitente;
    }

    public String getCepEmitente() {
        return cepEmitente;
    }

    public void setCepEmitente(String cepEmitente) {
        this.cepEmitente = cepEmitente;
    }

    public String getTelefoneEmitente() {
        return telefoneEmitente;
    }

    public void setTelefoneEmitente(String telefoneEmitente) {
        this.telefoneEmitente = telefoneEmitente;
    }

    public String getInscricaoEstadualEmitente() {
        return inscricaoEstadualEmitente;
    }

    public void setInscricaoEstadualEmitente(String inscricaoEstadualEmitente) {
        this.inscricaoEstadualEmitente = inscricaoEstadualEmitente;
    }

    public String getInscricaoEstadualStEmitente() {
        return inscricaoEstadualStEmitente;
    }

    public void setInscricaoEstadualStEmitente(String inscricaoEstadualStEmitente) {
        this.inscricaoEstadualStEmitente = inscricaoEstadualStEmitente;
    }

    public String getInscricaoMunicipalEmitente() {
        return inscricaoMunicipalEmitente;
    }

    public void setInscricaoMunicipalEmitente(String inscricaoMunicipalEmitente) {
        this.inscricaoMunicipalEmitente = inscricaoMunicipalEmitente;
    }

    public String getCnaeFiscalEmitente() {
        return cnaeFiscalEmitente;
    }

    public void setCnaeFiscalEmitente(String cnaeFiscalEmitente) {
        this.cnaeFiscalEmitente = cnaeFiscalEmitente;
    }

    public NFeRegimeTributarioEmitenteEnum getRegimeTributarioEmitente() {
        return regimeTributarioEmitente;
    }

    public void setRegimeTributarioEmitente(NFeRegimeTributarioEmitenteEnum regimeTributarioEmitente) {
        this.regimeTributarioEmitente = regimeTributarioEmitente;
    }

    public String getCnpjDestinatario() {
        return cnpjDestinatario;
    }

    public void setCnpjDestinatario(String cnpjDestinatario) {
        this.cnpjDestinatario = cnpjDestinatario;
    }

    public String getCpfDestinatario() {
        return cpfDestinatario;
    }

    public void setCpfDestinatario(String cpfDestinatario) {
        this.cpfDestinatario = cpfDestinatario;
    }

    public String getIdEstrangeiroDestinatario() {
        return idEstrangeiroDestinatario;
    }

    public void setIdEstrangeiroDestinatario(String idEstrangeiroDestinatario) {
        this.idEstrangeiroDestinatario = idEstrangeiroDestinatario;
    }

    public String getNomeDestinatario() {
        return nomeDestinatario;
    }

    public void setNomeDestinatario(String nomeDestinatario) {
        this.nomeDestinatario = nomeDestinatario;
    }

    public String getLogradouroDestinatario() {
        return logradouroDestinatario;
    }

    public void setLogradouroDestinatario(String logradouroDestinatario) {
        this.logradouroDestinatario = logradouroDestinatario;
    }

    public String getNumeroDestinatario() {
        return numeroDestinatario;
    }

    public void setNumeroDestinatario(String numeroDestinatario) {
        this.numeroDestinatario = numeroDestinatario;
    }

    public String getComplementoDestinatario() {
        return complementoDestinatario;
    }

    public void setComplementoDestinatario(String complementoDestinatario) {
        this.complementoDestinatario = complementoDestinatario;
    }

    public String getBairroDestinatario() {
        return bairroDestinatario;
    }

    public void setBairroDestinatario(String bairroDestinatario) {
        this.bairroDestinatario = bairroDestinatario;
    }

    public String getCodigoMunicipioDestinatario() {
        return codigoMunicipioDestinatario;
    }

    public void setCodigoMunicipioDestinatario(String codigoMunicipioDestinatario) {
        this.codigoMunicipioDestinatario = codigoMunicipioDestinatario;
    }

    public String getMunicipioDestinatario() {
        return municipioDestinatario;
    }

    public void setMunicipioDestinatario(String municipioDestinatario) {
        this.municipioDestinatario = municipioDestinatario;
    }

    public NFeUnidadeFederativaEnum getUfDestinatario() {
        return ufDestinatario;
    }

    public void setUfDestinatario(NFeUnidadeFederativaEnum ufDestinatario) {
        this.ufDestinatario = ufDestinatario;
    }

    public String getCepDestinatario() {
        return cepDestinatario;
    }

    public void setCepDestinatario(String cepDestinatario) {
        this.cepDestinatario = cepDestinatario;
    }

    public String getCodigoPaisDestinatario() {
        return codigoPaisDestinatario;
    }

    public void setCodigoPaisDestinatario(String codigoPaisDestinatario) {
        this.codigoPaisDestinatario = codigoPaisDestinatario;
    }

    public String getPaisDestinatario() {
        return paisDestinatario;
    }

    public void setPaisDestinatario(String paisDestinatario) {
        this.paisDestinatario = paisDestinatario;
    }

    public String getTelefoneDestinatario() {
        return telefoneDestinatario;
    }

    public void setTelefoneDestinatario(String telefoneDestinatario) {
        this.telefoneDestinatario = telefoneDestinatario;
    }

    public NFeIndicadorInscricaoEstadualDestinatarioEnum getIndicadorInscricaoEstadualDestinatario() {
        return indicadorInscricaoEstadualDestinatario;
    }

    public void setIndicadorInscricaoEstadualDestinatario(NFeIndicadorInscricaoEstadualDestinatarioEnum indicadorInscricaoEstadualDestinatario) {
        this.indicadorInscricaoEstadualDestinatario = indicadorInscricaoEstadualDestinatario;
    }

    public String getInscricaoEstadualDestinatario() {
        return inscricaoEstadualDestinatario;
    }

    public void setInscricaoEstadualDestinatario(String inscricaoEstadualDestinatario) {
        this.inscricaoEstadualDestinatario = inscricaoEstadualDestinatario;
    }

    public String getInscricaoSuframaDestinatario() {
        return inscricaoSuframaDestinatario;
    }

    public void setInscricaoSuframaDestinatario(String inscricaoSuframaDestinatario) {
        this.inscricaoSuframaDestinatario = inscricaoSuframaDestinatario;
    }

    public String getInscricaoMunicipalDestinatario() {
        return inscricaoMunicipalDestinatario;
    }

    public void setInscricaoMunicipalDestinatario(String inscricaoMunicipalDestinatario) {
        this.inscricaoMunicipalDestinatario = inscricaoMunicipalDestinatario;
    }

    public String getEmailDestinatario() {
        return emailDestinatario;
    }

    public void setEmailDestinatario(String emailDestinatario) {
        this.emailDestinatario = emailDestinatario;
    }

    public String getCnpjRetirada() {
        return cnpjRetirada;
    }

    public void setCnpjRetirada(String cnpjRetirada) {
        this.cnpjRetirada = cnpjRetirada;
    }

    public String getCpfRetirada() {
        return cpfRetirada;
    }

    public void setCpfRetirada(String cpfRetirada) {
        this.cpfRetirada = cpfRetirada;
    }

    public String getLogradouroRetirada() {
        return logradouroRetirada;
    }

    public void setLogradouroRetirada(String logradouroRetirada) {
        this.logradouroRetirada = logradouroRetirada;
    }

    public String getNumeroRetirada() {
        return numeroRetirada;
    }

    public void setNumeroRetirada(String numeroRetirada) {
        this.numeroRetirada = numeroRetirada;
    }

    public String getComplementoRetirada() {
        return complementoRetirada;
    }

    public void setComplementoRetirada(String complementoRetirada) {
        this.complementoRetirada = complementoRetirada;
    }

    public String getBairroRetirada() {
        return bairroRetirada;
    }

    public void setBairroRetirada(String bairroRetirada) {
        this.bairroRetirada = bairroRetirada;
    }

    public String getCodigoMunicipioRetirada() {
        return codigoMunicipioRetirada;
    }

    public void setCodigoMunicipioRetirada(String codigoMunicipioRetirada) {
        this.codigoMunicipioRetirada = codigoMunicipioRetirada;
    }

    public String getMunicipioRetirada() {
        return municipioRetirada;
    }

    public void setMunicipioRetirada(String municipioRetirada) {
        this.municipioRetirada = municipioRetirada;
    }

    public NFeUnidadeFederativaEnum getUfRetirada() {
        return ufRetirada;
    }

    public void setUfRetirada(NFeUnidadeFederativaEnum ufRetirada) {
        this.ufRetirada = ufRetirada;
    }

    public String getCnpjEntrega() {
        return cnpjEntrega;
    }

    public void setCnpjEntrega(String cnpjEntrega) {
        this.cnpjEntrega = cnpjEntrega;
    }

    public String getCpfEntrega() {
        return cpfEntrega;
    }

    public void setCpfEntrega(String cpfEntrega) {
        this.cpfEntrega = cpfEntrega;
    }

    public String getLogradouroEntrega() {
        return logradouroEntrega;
    }

    public void setLogradouroEntrega(String logradouroEntrega) {
        this.logradouroEntrega = logradouroEntrega;
    }

    public String getNumeroEntrega() {
        return numeroEntrega;
    }

    public void setNumeroEntrega(String numeroEntrega) {
        this.numeroEntrega = numeroEntrega;
    }

    public String getComplementoEntrega() {
        return complementoEntrega;
    }

    public void setComplementoEntrega(String complementoEntrega) {
        this.complementoEntrega = complementoEntrega;
    }

    public String getBairroEntrega() {
        return bairroEntrega;
    }

    public void setBairroEntrega(String bairroEntrega) {
        this.bairroEntrega = bairroEntrega;
    }

    public String getCodigoMunicipioEntrega() {
        return codigoMunicipioEntrega;
    }

    public void setCodigoMunicipioEntrega(String codigoMunicipioEntrega) {
        this.codigoMunicipioEntrega = codigoMunicipioEntrega;
    }

    public String getMunicipioEntrega() {
        return municipioEntrega;
    }

    public void setMunicipioEntrega(String municipioEntrega) {
        this.municipioEntrega = municipioEntrega;
    }

    public NFeUnidadeFederativaEnum getUfEntrega() {
        return ufEntrega;
    }

    public void setUfEntrega(NFeUnidadeFederativaEnum ufEntrega) {
        this.ufEntrega = ufEntrega;
    }

    public List<NFePessoaAutorizada> getPessoasAutorizadas() {
        return pessoasAutorizadas;
    }

    public void setPessoasAutorizadas(List<NFePessoaAutorizada> pessoasAutorizadas) {
        this.pessoasAutorizadas = pessoasAutorizadas;
    }

    public List<NFeItem> getItems() {
        return items;
    }

    public void setItems(List<NFeItem> items) {
        this.items = items;
    }

    public BigDecimal getIcmsBaseCalculo() {
        return icmsBaseCalculo;
    }

    public void setIcmsBaseCalculo(BigDecimal icmsBaseCalculo) {
        this.icmsBaseCalculo = icmsBaseCalculo;
    }

    public BigDecimal getIcmsValorTotal() {
        return icmsValorTotal;
    }

    public void setIcmsValorTotal(BigDecimal icmsValorTotal) {
        this.icmsValorTotal = icmsValorTotal;
    }

    public BigDecimal getIcmsValorTotalDesonerado() {
        return icmsValorTotalDesonerado;
    }

    public void setIcmsValorTotalDesonerado(BigDecimal icmsValorTotalDesonerado) {
        this.icmsValorTotalDesonerado = icmsValorTotalDesonerado;
    }

    public BigDecimal getFcpValorTotalUfDestino() {
        return fcpValorTotalUfDestino;
    }

    public void setFcpValorTotalUfDestino(BigDecimal fcpValorTotalUfDestino) {
        this.fcpValorTotalUfDestino = fcpValorTotalUfDestino;
    }

    public BigDecimal getIcmsValorTotalUfDestino() {
        return icmsValorTotalUfDestino;
    }

    public void setIcmsValorTotalUfDestino(BigDecimal icmsValorTotalUfDestino) {
        this.icmsValorTotalUfDestino = icmsValorTotalUfDestino;
    }

    public BigDecimal getIcmsValorTotalUfRemetente() {
        return icmsValorTotalUfRemetente;
    }

    public void setIcmsValorTotalUfRemetente(BigDecimal icmsValorTotalUfRemetente) {
        this.icmsValorTotalUfRemetente = icmsValorTotalUfRemetente;
    }

    public BigDecimal getFcpValorTotal() {
        return fcpValorTotal;
    }

    public void setFcpValorTotal(BigDecimal fcpValorTotal) {
        this.fcpValorTotal = fcpValorTotal;
    }

    public BigDecimal getIcmsBaseCalculoSt() {
        return icmsBaseCalculoSt;
    }

    public void setIcmsBaseCalculoSt(BigDecimal icmsBaseCalculoSt) {
        this.icmsBaseCalculoSt = icmsBaseCalculoSt;
    }

    public BigDecimal getIcmsValorTotalSt() {
        return icmsValorTotalSt;
    }

    public void setIcmsValorTotalSt(BigDecimal icmsValorTotalSt) {
        this.icmsValorTotalSt = icmsValorTotalSt;
    }

    public BigDecimal getFcpValorTotalSt() {
        return fcpValorTotalSt;
    }

    public void setFcpValorTotalSt(BigDecimal fcpValorTotalSt) {
        this.fcpValorTotalSt = fcpValorTotalSt;
    }

    public BigDecimal getFcpValorTotalRetidoSt() {
        return fcpValorTotalRetidoSt;
    }

    public void setFcpValorTotalRetidoSt(BigDecimal fcpValorTotalRetidoSt) {
        this.fcpValorTotalRetidoSt = fcpValorTotalRetidoSt;
    }

    public BigDecimal getValorProdutos() {
        return valorProdutos;
    }

    public void setValorProdutos(BigDecimal valorProdutos) {
        this.valorProdutos = valorProdutos;
    }

    public BigDecimal getValorFrete() {
        return valorFrete;
    }

    public void setValorFrete(BigDecimal valorFrete) {
        this.valorFrete = valorFrete;
    }

    public BigDecimal getValorSeguro() {
        return valorSeguro;
    }

    public void setValorSeguro(BigDecimal valorSeguro) {
        this.valorSeguro = valorSeguro;
    }

    public BigDecimal getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(BigDecimal valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    public BigDecimal getValorTotalII() {
        return valorTotalII;
    }

    public void setValorTotalII(BigDecimal valorTotalII) {
        this.valorTotalII = valorTotalII;
    }

    public BigDecimal getValorIpi() {
        return valorIpi;
    }

    public void setValorIpi(BigDecimal valorIpi) {
        this.valorIpi = valorIpi;
    }

    public BigDecimal getValorIpiDevolvido() {
        return valorIpiDevolvido;
    }

    public void setValorIpiDevolvido(BigDecimal valorIpiDevolvido) {
        this.valorIpiDevolvido = valorIpiDevolvido;
    }

    public BigDecimal getValorPis() {
        return valorPis;
    }

    public void setValorPis(BigDecimal valorPis) {
        this.valorPis = valorPis;
    }

    public BigDecimal getValorCofins() {
        return valorCofins;
    }

    public void setValorCofins(BigDecimal valorCofins) {
        this.valorCofins = valorCofins;
    }

    public BigDecimal getValorOutrasDespesas() {
        return valorOutrasDespesas;
    }

    public void setValorOutrasDespesas(BigDecimal valorOutrasDespesas) {
        this.valorOutrasDespesas = valorOutrasDespesas;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public BigDecimal getValorTotalTributos() {
        return valorTotalTributos;
    }

    public void setValorTotalTributos(BigDecimal valorTotalTributos) {
        this.valorTotalTributos = valorTotalTributos;
    }

    public BigDecimal getValorTotalServicos() {
        return valorTotalServicos;
    }

    public void setValorTotalServicos(BigDecimal valorTotalServicos) {
        this.valorTotalServicos = valorTotalServicos;
    }

    public BigDecimal getIssqnBaseCalculo() {
        return issqnBaseCalculo;
    }

    public void setIssqnBaseCalculo(BigDecimal issqnBaseCalculo) {
        this.issqnBaseCalculo = issqnBaseCalculo;
    }

    public BigDecimal getIssqnValorTotal() {
        return issqnValorTotal;
    }

    public void setIssqnValorTotal(BigDecimal issqnValorTotal) {
        this.issqnValorTotal = issqnValorTotal;
    }

    public BigDecimal getValorPisServicos() {
        return valorPisServicos;
    }

    public void setValorPisServicos(BigDecimal valorPisServicos) {
        this.valorPisServicos = valorPisServicos;
    }

    public BigDecimal getValorCofinsServicos() {
        return valorCofinsServicos;
    }

    public void setValorCofinsServicos(BigDecimal valorCofinsServicos) {
        this.valorCofinsServicos = valorCofinsServicos;
    }

    public LocalDate getDataPrestacaoServico() {
        return dataPrestacaoServico;
    }

    public void setDataPrestacaoServico(LocalDate dataPrestacaoServico) {
        this.dataPrestacaoServico = dataPrestacaoServico;
    }

    public BigDecimal getIssqnValorTotalDeducao() {
        return issqnValorTotalDeducao;
    }

    public void setIssqnValorTotalDeducao(BigDecimal issqnValorTotalDeducao) {
        this.issqnValorTotalDeducao = issqnValorTotalDeducao;
    }

    public BigDecimal getIssqnValorTotalOutrasRetencoes() {
        return issqnValorTotalOutrasRetencoes;
    }

    public void setIssqnValorTotalOutrasRetencoes(BigDecimal issqnValorTotalOutrasRetencoes) {
        this.issqnValorTotalOutrasRetencoes = issqnValorTotalOutrasRetencoes;
    }

    public BigDecimal getIssqnValorTotalDescontoIncondicionado() {
        return issqnValorTotalDescontoIncondicionado;
    }

    public void setIssqnValorTotalDescontoIncondicionado(BigDecimal issqnValorTotalDescontoIncondicionado) {
        this.issqnValorTotalDescontoIncondicionado = issqnValorTotalDescontoIncondicionado;
    }

    public BigDecimal getIssqnValorTotalDescontoCondicionado() {
        return issqnValorTotalDescontoCondicionado;
    }

    public void setIssqnValorTotalDescontoCondicionado(BigDecimal issqnValorTotalDescontoCondicionado) {
        this.issqnValorTotalDescontoCondicionado = issqnValorTotalDescontoCondicionado;
    }

    public BigDecimal getIssqnValorTotalRetencao() {
        return issqnValorTotalRetencao;
    }

    public void setIssqnValorTotalRetencao(BigDecimal issqnValorTotalRetencao) {
        this.issqnValorTotalRetencao = issqnValorTotalRetencao;
    }

    public NFeCodigoRegimeEspecialTributacaoEnum getCodigoRegimeEspecialTributacao() {
        return codigoRegimeEspecialTributacao;
    }

    public void setCodigoRegimeEspecialTributacao(NFeCodigoRegimeEspecialTributacaoEnum codigoRegimeEspecialTributacao) {
        this.codigoRegimeEspecialTributacao = codigoRegimeEspecialTributacao;
    }

    public BigDecimal getPisValorRetido() {
        return pisValorRetido;
    }

    public void setPisValorRetido(BigDecimal pisValorRetido) {
        this.pisValorRetido = pisValorRetido;
    }

    public BigDecimal getCofinsValorRetido() {
        return cofinsValorRetido;
    }

    public void setCofinsValorRetido(BigDecimal cofinsValorRetido) {
        this.cofinsValorRetido = cofinsValorRetido;
    }

    public BigDecimal getCsllValorRetido() {
        return csllValorRetido;
    }

    public void setCsllValorRetido(BigDecimal csllValorRetido) {
        this.csllValorRetido = csllValorRetido;
    }

    public BigDecimal getIrrfBaseCalculo() {
        return irrfBaseCalculo;
    }

    public void setIrrfBaseCalculo(BigDecimal irrfBaseCalculo) {
        this.irrfBaseCalculo = irrfBaseCalculo;
    }

    public BigDecimal getIrrfValorRetido() {
        return irrfValorRetido;
    }

    public void setIrrfValorRetido(BigDecimal irrfValorRetido) {
        this.irrfValorRetido = irrfValorRetido;
    }

    public BigDecimal getPrevSocialBaseCalculo() {
        return prevSocialBaseCalculo;
    }

    public void setPrevSocialBaseCalculo(BigDecimal prevSocialBaseCalculo) {
        this.prevSocialBaseCalculo = prevSocialBaseCalculo;
    }

    public BigDecimal getPrevSocialValorRetido() {
        return prevSocialValorRetido;
    }

    public void setPrevSocialValorRetido(BigDecimal prevSocialValorRetido) {
        this.prevSocialValorRetido = prevSocialValorRetido;
    }

    public NFeModalidadeFreteEnum getModalidadeFrete() {
        return modalidadeFrete;
    }

    public void setModalidadeFrete(NFeModalidadeFreteEnum modalidadeFrete) {
        this.modalidadeFrete = modalidadeFrete;
    }

    public String getCnpjTransportador() {
        return cnpjTransportador;
    }

    public void setCnpjTransportador(String cnpjTransportador) {
        this.cnpjTransportador = cnpjTransportador;
    }

    public String getCpfTransportador() {
        return cpfTransportador;
    }

    public void setCpfTransportador(String cpfTransportador) {
        this.cpfTransportador = cpfTransportador;
    }

    public String getNomeTransportador() {
        return nomeTransportador;
    }

    public void setNomeTransportador(String nomeTransportador) {
        this.nomeTransportador = nomeTransportador;
    }

    public String getInscricaoEstadualTransportador() {
        return inscricaoEstadualTransportador;
    }

    public void setInscricaoEstadualTransportador(String inscricaoEstadualTransportador) {
        this.inscricaoEstadualTransportador = inscricaoEstadualTransportador;
    }

    public String getEnderecoTransportador() {
        return enderecoTransportador;
    }

    public void setEnderecoTransportador(String enderecoTransportador) {
        this.enderecoTransportador = enderecoTransportador;
    }

    public String getMunicipioTransportador() {
        return municipioTransportador;
    }

    public void setMunicipioTransportador(String municipioTransportador) {
        this.municipioTransportador = municipioTransportador;
    }

    public NFeUnidadeFederativaEnum getUfTransportador() {
        return ufTransportador;
    }

    public void setUfTransportador(NFeUnidadeFederativaEnum ufTransportador) {
        this.ufTransportador = ufTransportador;
    }

    public BigDecimal getTransporteIcmsServico() {
        return transporteIcmsServico;
    }

    public void setTransporteIcmsServico(BigDecimal transporteIcmsServico) {
        this.transporteIcmsServico = transporteIcmsServico;
    }

    public BigDecimal getTransporteIcmsBaseCalculo() {
        return transporteIcmsBaseCalculo;
    }

    public void setTransporteIcmsBaseCalculo(BigDecimal transporteIcmsBaseCalculo) {
        this.transporteIcmsBaseCalculo = transporteIcmsBaseCalculo;
    }

    public BigDecimal getTransporteIcmsAliquota() {
        return transporteIcmsAliquota;
    }

    public void setTransporteIcmsAliquota(BigDecimal transporteIcmsAliquota) {
        this.transporteIcmsAliquota = transporteIcmsAliquota;
    }

    public BigDecimal getTransporteIcmsValor() {
        return transporteIcmsValor;
    }

    public void setTransporteIcmsValor(BigDecimal transporteIcmsValor) {
        this.transporteIcmsValor = transporteIcmsValor;
    }

    public String getTransporteIcmsCfop() {
        return transporteIcmsCfop;
    }

    public void setTransporteIcmsCfop(String transporteIcmsCfop) {
        this.transporteIcmsCfop = transporteIcmsCfop;
    }

    public String getTransporteIcmsCodigoMunicipio() {
        return transporteIcmsCodigoMunicipio;
    }

    public void setTransporteIcmsCodigoMunicipio(String transporteIcmsCodigoMunicipio) {
        this.transporteIcmsCodigoMunicipio = transporteIcmsCodigoMunicipio;
    }

    public String getVeiculoPlaca() {
        return veiculoPlaca;
    }

    public void setVeiculoPlaca(String veiculoPlaca) {
        this.veiculoPlaca = veiculoPlaca;
    }

    public NFeUnidadeFederativaEnum getVeiculoUf() {
        return veiculoUf;
    }

    public void setVeiculoUf(NFeUnidadeFederativaEnum veiculoUf) {
        this.veiculoUf = veiculoUf;
    }

    public String getVeiculoRntc() {
        return veiculoRntc;
    }

    public void setVeiculoRntc(String veiculoRntc) {
        this.veiculoRntc = veiculoRntc;
    }

    public List<NFeReboque> getReboques() {
        return reboques;
    }

    public void setReboques(List<NFeReboque> reboques) {
        this.reboques = reboques;
    }

    public String getVeiculoIdentificacaoVagao() {
        return veiculoIdentificacaoVagao;
    }

    public void setVeiculoIdentificacaoVagao(String veiculoIdentificacaoVagao) {
        this.veiculoIdentificacaoVagao = veiculoIdentificacaoVagao;
    }

    public String getVeiculoIdentificacaoBalsa() {
        return veiculoIdentificacaoBalsa;
    }

    public void setVeiculoIdentificacaoBalsa(String veiculoIdentificacaoBalsa) {
        this.veiculoIdentificacaoBalsa = veiculoIdentificacaoBalsa;
    }

    public List<NFeVolumeTransportado> getVolumes() {
        return volumes;
    }

    public void setVolumes(List<NFeVolumeTransportado> volumes) {
        this.volumes = volumes;
    }

    public String getNumeroFatura() {
        return numeroFatura;
    }

    public void setNumeroFatura(String numeroFatura) {
        this.numeroFatura = numeroFatura;
    }

    public BigDecimal getValorOriginalFatura() {
        return valorOriginalFatura;
    }

    public void setValorOriginalFatura(BigDecimal valorOriginalFatura) {
        this.valorOriginalFatura = valorOriginalFatura;
    }

    public BigDecimal getValorDescontoFatura() {
        return valorDescontoFatura;
    }

    public void setValorDescontoFatura(BigDecimal valorDescontoFatura) {
        this.valorDescontoFatura = valorDescontoFatura;
    }

    public BigDecimal getValorLiquidoFatura() {
        return valorLiquidoFatura;
    }

    public void setValorLiquidoFatura(BigDecimal valorLiquidoFatura) {
        this.valorLiquidoFatura = valorLiquidoFatura;
    }

    public List<NFeDuplicataNotaFiscal> getDuplicatas() {
        return duplicatas;
    }

    public void setDuplicatas(List<NFeDuplicataNotaFiscal> duplicatas) {
        this.duplicatas = duplicatas;
    }

    public List<NFeFormaPagamento> getFormasPagamento() {
        return formasPagamento;
    }

    public void setFormasPagamento(List<NFeFormaPagamento> formasPagamento) {
        this.formasPagamento = formasPagamento;
    }

    public String getInformacoesAdicionaisFisco() {
        return informacoesAdicionaisFisco;
    }

    public void setInformacoesAdicionaisFisco(String informacoesAdicionaisFisco) {
        this.informacoesAdicionaisFisco = informacoesAdicionaisFisco;
    }

    public String getInformacoesAdicionaisContribuinte() {
        return informacoesAdicionaisContribuinte;
    }

    public void setInformacoesAdicionaisContribuinte(String informacoesAdicionaisContribuinte) {
        this.informacoesAdicionaisContribuinte = informacoesAdicionaisContribuinte;
    }

    public NFeUnidadeFederativaEnum getUfLocalEmbarque() {
        return ufLocalEmbarque;
    }

    public void setUfLocalEmbarque(NFeUnidadeFederativaEnum ufLocalEmbarque) {
        this.ufLocalEmbarque = ufLocalEmbarque;
    }

    public String getLocalEmbarque() {
        return localEmbarque;
    }

    public void setLocalEmbarque(String localEmbarque) {
        this.localEmbarque = localEmbarque;
    }

    public String getLocalDespacho() {
        return localDespacho;
    }

    public void setLocalDespacho(String localDespacho) {
        this.localDespacho = localDespacho;
    }

    public static final class Builder {

        private String naturezaOperacao;

        private String serie;

        private String numero;

        private OffsetDateTime dataEmissao;

        private OffsetDateTime dataEntradaSaida;

        private NFeTipoDocumentoEnum tipoDocumento;

        private NFeLocalDestinoEnum localDestino;

        private NFeFinalidadeEmissaoEnum finalidadeEmissao;

        private NFeConsumidorFinalEnum consumidorFinal;

        private NFePresencaCompradorEnum presencaComprador;

        private List<NFeNotaReferenciada> notasReferenciadas;

        private String cnpjEmitente;

        private String nomeEmitente;

        private String nomeFantasiaEmitente;

        private String logradouroEmitente;

        private String numeroEmitente;

        private String complementoEmitente;

        private String bairroEmitente;

        private String municipioEmitente;

        private NFeUnidadeFederativaEnum ufEmitente;

        private String cepEmitente;

        private String telefoneEmitente;

        private String inscricaoEstadualEmitente;

        private String inscricaoEstadualStEmitente;

        private String inscricaoMunicipalEmitente;

        private String cnaeFiscalEmitente;

        private NFeRegimeTributarioEmitenteEnum regimeTributarioEmitente;

        private String cnpjDestinatario;

        private String cpfDestinatario;

        private String idEstrangeiroDestinatario;

        private String nomeDestinatario;

        private String logradouroDestinatario;

        private String numeroDestinatario;

        private String complementoDestinatario;

        private String bairroDestinatario;

        private String codigoMunicipioDestinatario;

        private String municipioDestinatario;

        private NFeUnidadeFederativaEnum ufDestinatario;

        private String cepDestinatario;

        private String codigoPaisDestinatario;

        private String paisDestinatario;

        private String telefoneDestinatario;

        private NFeIndicadorInscricaoEstadualDestinatarioEnum indicadorInscricaoEstadualDestinatario;

        private String inscricaoEstadualDestinatario;

        private String inscricaoSuframaDestinatario;

        private String inscricaoMunicipalDestinatario;

        private String emailDestinatario;

        private String cnpjRetirada;

        private String cpfRetirada;

        private String logradouroRetirada;

        private String numeroRetirada;

        private String complementoRetirada;

        private String bairroRetirada;

        private String codigoMunicipioRetirada;

        private String municipioRetirada;

        private NFeUnidadeFederativaEnum ufRetirada;

        private String cnpjEntrega;

        private String cpfEntrega;

        private String logradouroEntrega;

        private String numeroEntrega;

        private String complementoEntrega;

        private String bairroEntrega;

        private String codigoMunicipioEntrega;

        private String municipioEntrega;

        private NFeUnidadeFederativaEnum ufEntrega;

        private List<NFePessoaAutorizada> pessoasAutorizadas;

        private List<NFeItem> items;

        private BigDecimal icmsBaseCalculo;

        private BigDecimal icmsValorTotal;

        private BigDecimal icmsValorTotalDesonerado;

        private BigDecimal fcpValorTotalUfDestino;

        private BigDecimal icmsValorTotalUfDestino;

        private BigDecimal icmsValorTotalUfRemetente;

        private BigDecimal fcpValorTotal;

        private BigDecimal icmsBaseCalculoSt;

        private BigDecimal icmsValorTotalSt;

        private BigDecimal fcpValorTotalSt;

        private BigDecimal fcpValorTotalRetidoSt;

        private BigDecimal valorProdutos;

        private BigDecimal valorFrete;

        private BigDecimal valorSeguro;

        private BigDecimal valorDesconto;

        private BigDecimal valorTotalII;

        private BigDecimal valorIpi;

        private BigDecimal valorIpiDevolvido;

        private BigDecimal valorPis;

        private BigDecimal valorCofins;

        private BigDecimal valorOutrasDespesas;

        private BigDecimal valorTotal;

        private BigDecimal valorTotalTributos;

        private BigDecimal valorTotalServicos;

        private BigDecimal issqnBaseCalculo;

        private BigDecimal issqnValorTotal;

        private BigDecimal valorPisServicos;

        private BigDecimal valorCofinsServicos;

        private LocalDate dataPrestacaoServico;

        private BigDecimal issqnValorTotalDeducao;

        private BigDecimal issqnValorTotalOutrasRetencoes;

        private BigDecimal issqnValorTotalDescontoIncondicionado;

        private BigDecimal issqnValorTotalDescontoCondicionado;

        private BigDecimal issqnValorTotalRetencao;

        private NFeCodigoRegimeEspecialTributacaoEnum codigoRegimeEspecialTributacao;

        private BigDecimal pisValorRetido;

        private BigDecimal cofinsValorRetido;

        private BigDecimal csllValorRetido;

        private BigDecimal irrfBaseCalculo;

        private BigDecimal irrfValorRetido;

        private BigDecimal prevSocialBaseCalculo;

        private BigDecimal prevSocialValorRetido;

        private NFeModalidadeFreteEnum modalidadeFrete;

        private String cnpjTransportador;

        private String cpfTransportador;

        private String nomeTransportador;

        private String inscricaoEstadualTransportador;

        private String enderecoTransportador;

        private String municipioTransportador;

        private NFeUnidadeFederativaEnum ufTransportador;

        private BigDecimal transporteIcmsServico;

        private BigDecimal transporteIcmsBaseCalculo;

        private BigDecimal transporteIcmsAliquota;

        private BigDecimal transporteIcmsValor;

        private String transporteIcmsCfop;

        private String transporteIcmsCodigoMunicipio;

        private String veiculoPlaca;

        private NFeUnidadeFederativaEnum veiculoUf;

        private String veiculoRntc;

        private List<NFeReboque> reboques;

        private String veiculoIdentificacaoVagao;

        private String veiculoIdentificacaoBalsa;

        private List<NFeVolumeTransportado> volumes;

        private String numeroFatura;

        private BigDecimal valorOriginalFatura;

        private BigDecimal valorDescontoFatura;

        private BigDecimal valorLiquidoFatura;

        private List<NFeDuplicataNotaFiscal> duplicatas;

        private List<NFeFormaPagamento> formasPagamento;

        private String informacoesAdicionaisFisco;

        private String informacoesAdicionaisContribuinte;

        private NFeUnidadeFederativaEnum ufLocalEmbarque;

        private String localEmbarque;

        private String localDespacho;

        private Builder() {
        }

        public Builder withNaturezaOperacao(String val) {
            naturezaOperacao = val;
            return this;
        }

        public Builder withSerie(String val) {
            serie = val;
            return this;
        }

        public Builder withNumero(String val) {
            numero = val;
            return this;
        }

        public Builder withDataEmissao(OffsetDateTime val) {
            dataEmissao = val;
            return this;
        }

        public Builder withDataEntradaSaida(OffsetDateTime val) {
            dataEntradaSaida = val;
            return this;
        }

        public Builder withTipoDocumento(NFeTipoDocumentoEnum val) {
            tipoDocumento = val;
            return this;
        }

        public Builder withLocalDestino(NFeLocalDestinoEnum val) {
            localDestino = val;
            return this;
        }

        public Builder withFinalidadeEmissao(NFeFinalidadeEmissaoEnum val) {
            finalidadeEmissao = val;
            return this;
        }

        public Builder withConsumidorFinal(NFeConsumidorFinalEnum val) {
            consumidorFinal = val;
            return this;
        }

        public Builder withPresencaComprador(NFePresencaCompradorEnum val) {
            presencaComprador = val;
            return this;
        }

        public Builder withNotasReferenciadas(List<NFeNotaReferenciada> val) {
            notasReferenciadas = val;
            return this;
        }

        public Builder withCnpjEmitente(String val) {
            cnpjEmitente = val;
            return this;
        }

        public Builder withNomeEmitente(String val) {
            nomeEmitente = val;
            return this;
        }

        public Builder withNomeFantasiaEmitente(String val) {
            nomeFantasiaEmitente = val;
            return this;
        }

        public Builder withLogradouroEmitente(String val) {
            logradouroEmitente = val;
            return this;
        }

        public Builder withNumeroEmitente(String val) {
            numeroEmitente = val;
            return this;
        }

        public Builder withComplementoEmitente(String val) {
            complementoEmitente = val;
            return this;
        }

        public Builder withBairroEmitente(String val) {
            bairroEmitente = val;
            return this;
        }

        public Builder withMunicipioEmitente(String val) {
            municipioEmitente = val;
            return this;
        }

        public Builder withUfEmitente(NFeUnidadeFederativaEnum val) {
            ufEmitente = val;
            return this;
        }

        public Builder withCepEmitente(String val) {
            cepEmitente = val;
            return this;
        }

        public Builder withTelefoneEmitente(String val) {
            telefoneEmitente = val;
            return this;
        }

        public Builder withInscricaoEstadualEmitente(String val) {
            inscricaoEstadualEmitente = val;
            return this;
        }

        public Builder withInscricaoEstadualStEmitente(String val) {
            inscricaoEstadualStEmitente = val;
            return this;
        }

        public Builder withInscricaoMunicipalEmitente(String val) {
            inscricaoMunicipalEmitente = val;
            return this;
        }

        public Builder withCnaeFiscalEmitente(String val) {
            cnaeFiscalEmitente = val;
            return this;
        }

        public Builder withRegimeTributarioEmitente(NFeRegimeTributarioEmitenteEnum val) {
            regimeTributarioEmitente = val;
            return this;
        }

        public Builder withCnpjDestinatario(String val) {
            cnpjDestinatario = val;
            return this;
        }

        public Builder withCpfDestinatario(String val) {
            cpfDestinatario = val;
            return this;
        }

        public Builder withIdEstrangeiroDestinatario(String val) {
            idEstrangeiroDestinatario = val;
            return this;
        }

        public Builder withNomeDestinatario(String val) {
            nomeDestinatario = val;
            return this;
        }

        public Builder withLogradouroDestinatario(String val) {
            logradouroDestinatario = val;
            return this;
        }

        public Builder withNumeroDestinatario(String val) {
            numeroDestinatario = val;
            return this;
        }

        public Builder withComplementoDestinatario(String val) {
            complementoDestinatario = val;
            return this;
        }

        public Builder withBairroDestinatario(String val) {
            bairroDestinatario = val;
            return this;
        }

        public Builder withCodigoMunicipioDestinatario(String val) {
            codigoMunicipioDestinatario = val;
            return this;
        }

        public Builder withMunicipioDestinatario(String val) {
            municipioDestinatario = val;
            return this;
        }

        public Builder withUfDestinatario(NFeUnidadeFederativaEnum val) {
            ufDestinatario = val;
            return this;
        }

        public Builder withCepDestinatario(String val) {
            cepDestinatario = val;
            return this;
        }

        public Builder withCodigoPaisDestinatario(String val) {
            codigoPaisDestinatario = val;
            return this;
        }

        public Builder withPaisDestinatario(String val) {
            paisDestinatario = val;
            return this;
        }

        public Builder withTelefoneDestinatario(String val) {
            telefoneDestinatario = val;
            return this;
        }

        public Builder withIndicadorInscricaoEstadualDestinatario(NFeIndicadorInscricaoEstadualDestinatarioEnum val) {
            indicadorInscricaoEstadualDestinatario = val;
            return this;
        }

        public Builder withInscricaoEstadualDestinatario(String val) {
            inscricaoEstadualDestinatario = val;
            return this;
        }

        public Builder withInscricaoSuframaDestinatario(String val) {
            inscricaoSuframaDestinatario = val;
            return this;
        }

        public Builder withInscricaoMunicipalDestinatario(String val) {
            inscricaoMunicipalDestinatario = val;
            return this;
        }

        public Builder withEmailDestinatario(String val) {
            emailDestinatario = val;
            return this;
        }

        public Builder withCnpjRetirada(String val) {
            cnpjRetirada = val;
            return this;
        }

        public Builder withCpfRetirada(String val) {
            cpfRetirada = val;
            return this;
        }

        public Builder withLogradouroRetirada(String val) {
            logradouroRetirada = val;
            return this;
        }

        public Builder withNumeroRetirada(String val) {
            numeroRetirada = val;
            return this;
        }

        public Builder withComplementoRetirada(String val) {
            complementoRetirada = val;
            return this;
        }

        public Builder withBairroRetirada(String val) {
            bairroRetirada = val;
            return this;
        }

        public Builder withCodigoMunicipioRetirada(String val) {
            codigoMunicipioRetirada = val;
            return this;
        }

        public Builder withMunicipioRetirada(String val) {
            municipioRetirada = val;
            return this;
        }

        public Builder withUfRetirada(NFeUnidadeFederativaEnum val) {
            ufRetirada = val;
            return this;
        }

        public Builder withCnpjEntrega(String val) {
            cnpjEntrega = val;
            return this;
        }

        public Builder withCpfEntrega(String val) {
            cpfEntrega = val;
            return this;
        }

        public Builder withLogradouroEntrega(String val) {
            logradouroEntrega = val;
            return this;
        }

        public Builder withNumeroEntrega(String val) {
            numeroEntrega = val;
            return this;
        }

        public Builder withComplementoEntrega(String val) {
            complementoEntrega = val;
            return this;
        }

        public Builder withBairroEntrega(String val) {
            bairroEntrega = val;
            return this;
        }

        public Builder withCodigoMunicipioEntrega(String val) {
            codigoMunicipioEntrega = val;
            return this;
        }

        public Builder withMunicipioEntrega(String val) {
            municipioEntrega = val;
            return this;
        }

        public Builder withUfEntrega(NFeUnidadeFederativaEnum val) {
            ufEntrega = val;
            return this;
        }

        public Builder withPessoasAutorizadas(List<NFePessoaAutorizada> val) {
            pessoasAutorizadas = val;
            return this;
        }

        public Builder withItems(List<NFeItem> val) {
            items = val;
            return this;
        }

        public Builder withIcmsBaseCalculo(BigDecimal val) {
            icmsBaseCalculo = val;
            return this;
        }

        public Builder withIcmsValorTotal(BigDecimal val) {
            icmsValorTotal = val;
            return this;
        }

        public Builder withIcmsValorTotalDesonerado(BigDecimal val) {
            icmsValorTotalDesonerado = val;
            return this;
        }

        public Builder withFcpValorTotalUfDestino(BigDecimal val) {
            fcpValorTotalUfDestino = val;
            return this;
        }

        public Builder withIcmsValorTotalUfDestino(BigDecimal val) {
            icmsValorTotalUfDestino = val;
            return this;
        }

        public Builder withIcmsValorTotalUfRemetente(BigDecimal val) {
            icmsValorTotalUfRemetente = val;
            return this;
        }

        public Builder withFcpValorTotal(BigDecimal val) {
            fcpValorTotal = val;
            return this;
        }

        public Builder withIcmsBaseCalculoSt(BigDecimal val) {
            icmsBaseCalculoSt = val;
            return this;
        }

        public Builder withIcmsValorTotalSt(BigDecimal val) {
            icmsValorTotalSt = val;
            return this;
        }

        public Builder withFcpValorTotalSt(BigDecimal val) {
            fcpValorTotalSt = val;
            return this;
        }

        public Builder withFcpValorTotalRetidoSt(BigDecimal val) {
            fcpValorTotalRetidoSt = val;
            return this;
        }

        public Builder withValorProdutos(BigDecimal val) {
            valorProdutos = val;
            return this;
        }

        public Builder withValorFrete(BigDecimal val) {
            valorFrete = val;
            return this;
        }

        public Builder withValorSeguro(BigDecimal val) {
            valorSeguro = val;
            return this;
        }

        public Builder withValorDesconto(BigDecimal val) {
            valorDesconto = val;
            return this;
        }

        public Builder withValorTotalII(BigDecimal val) {
            valorTotalII = val;
            return this;
        }

        public Builder withValorIpi(BigDecimal val) {
            valorIpi = val;
            return this;
        }

        public Builder withValorIpiDevolvido(BigDecimal val) {
            valorIpiDevolvido = val;
            return this;
        }

        public Builder withValorPis(BigDecimal val) {
            valorPis = val;
            return this;
        }

        public Builder withValorCofins(BigDecimal val) {
            valorCofins = val;
            return this;
        }

        public Builder withValorOutrasDespesas(BigDecimal val) {
            valorOutrasDespesas = val;
            return this;
        }

        public Builder withValorTotal(BigDecimal val) {
            valorTotal = val;
            return this;
        }

        public Builder withValorTotalTributos(BigDecimal val) {
            valorTotalTributos = val;
            return this;
        }

        public Builder withValorTotalServicos(BigDecimal val) {
            valorTotalServicos = val;
            return this;
        }

        public Builder withIssqnBaseCalculo(BigDecimal val) {
            issqnBaseCalculo = val;
            return this;
        }

        public Builder withIssqnValorTotal(BigDecimal val) {
            issqnValorTotal = val;
            return this;
        }

        public Builder withValorPisServicos(BigDecimal val) {
            valorPisServicos = val;
            return this;
        }

        public Builder withValorCofinsServicos(BigDecimal val) {
            valorCofinsServicos = val;
            return this;
        }

        public Builder withDataPrestacaoServico(LocalDate val) {
            dataPrestacaoServico = val;
            return this;
        }

        public Builder withIssqnValorTotalDeducao(BigDecimal val) {
            issqnValorTotalDeducao = val;
            return this;
        }

        public Builder withIssqnValorTotalOutrasRetencoes(BigDecimal val) {
            issqnValorTotalOutrasRetencoes = val;
            return this;
        }

        public Builder withIssqnValorTotalDescontoIncondicionado(BigDecimal val) {
            issqnValorTotalDescontoIncondicionado = val;
            return this;
        }

        public Builder withIssqnValorTotalDescontoCondicionado(BigDecimal val) {
            issqnValorTotalDescontoCondicionado = val;
            return this;
        }

        public Builder withIssqnValorTotalRetencao(BigDecimal val) {
            issqnValorTotalRetencao = val;
            return this;
        }

        public Builder withCodigoRegimeEspecialTributacao(NFeCodigoRegimeEspecialTributacaoEnum val) {
            codigoRegimeEspecialTributacao = val;
            return this;
        }

        public Builder withPisValorRetido(BigDecimal val) {
            pisValorRetido = val;
            return this;
        }

        public Builder withCofinsValorRetido(BigDecimal val) {
            cofinsValorRetido = val;
            return this;
        }

        public Builder withCsllValorRetido(BigDecimal val) {
            csllValorRetido = val;
            return this;
        }

        public Builder withIrrfBaseCalculo(BigDecimal val) {
            irrfBaseCalculo = val;
            return this;
        }

        public Builder withIrrfValorRetido(BigDecimal val) {
            irrfValorRetido = val;
            return this;
        }

        public Builder withPrevSocialBaseCalculo(BigDecimal val) {
            prevSocialBaseCalculo = val;
            return this;
        }

        public Builder withPrevSocialValorRetido(BigDecimal val) {
            prevSocialValorRetido = val;
            return this;
        }

        public Builder withModalidadeFrete(NFeModalidadeFreteEnum val) {
            modalidadeFrete = val;
            return this;
        }

        public Builder withCnpjTransportador(String val) {
            cnpjTransportador = val;
            return this;
        }

        public Builder withCpfTransportador(String val) {
            cpfTransportador = val;
            return this;
        }

        public Builder withNomeTransportador(String val) {
            nomeTransportador = val;
            return this;
        }

        public Builder withInscricaoEstadualTransportador(String val) {
            inscricaoEstadualTransportador = val;
            return this;
        }

        public Builder withEnderecoTransportador(String val) {
            enderecoTransportador = val;
            return this;
        }

        public Builder withMunicipioTransportador(String val) {
            municipioTransportador = val;
            return this;
        }

        public Builder withUfTransportador(NFeUnidadeFederativaEnum val) {
            ufTransportador = val;
            return this;
        }

        public Builder withTransporteIcmsServico(BigDecimal val) {
            transporteIcmsServico = val;
            return this;
        }

        public Builder withTransporteIcmsBaseCalculo(BigDecimal val) {
            transporteIcmsBaseCalculo = val;
            return this;
        }

        public Builder withTransporteIcmsAliquota(BigDecimal val) {
            transporteIcmsAliquota = val;
            return this;
        }

        public Builder withTransporteIcmsValor(BigDecimal val) {
            transporteIcmsValor = val;
            return this;
        }

        public Builder withTransporteIcmsCfop(String val) {
            transporteIcmsCfop = val;
            return this;
        }

        public Builder withTransporteIcmsCodigoMunicipio(String val) {
            transporteIcmsCodigoMunicipio = val;
            return this;
        }

        public Builder withVeiculoPlaca(String val) {
            veiculoPlaca = val;
            return this;
        }

        public Builder withVeiculoUf(NFeUnidadeFederativaEnum val) {
            veiculoUf = val;
            return this;
        }

        public Builder withVeiculoRntc(String val) {
            veiculoRntc = val;
            return this;
        }

        public Builder withReboques(List<NFeReboque> val) {
            reboques = val;
            return this;
        }

        public Builder withVeiculoIdentificacaoVagao(String val) {
            veiculoIdentificacaoVagao = val;
            return this;
        }

        public Builder withVeiculoIdentificacaoBalsa(String val) {
            veiculoIdentificacaoBalsa = val;
            return this;
        }

        public Builder withVolumes(List<NFeVolumeTransportado> val) {
            volumes = val;
            return this;
        }

        public Builder withNumeroFatura(String val) {
            numeroFatura = val;
            return this;
        }

        public Builder withValorOriginalFatura(BigDecimal val) {
            valorOriginalFatura = val;
            return this;
        }

        public Builder withValorDescontoFatura(BigDecimal val) {
            valorDescontoFatura = val;
            return this;
        }

        public Builder withValorLiquidoFatura(BigDecimal val) {
            valorLiquidoFatura = val;
            return this;
        }

        public Builder withDuplicatas(List<NFeDuplicataNotaFiscal> val) {
            duplicatas = val;
            return this;
        }

        public Builder withFormasPagamento(List<NFeFormaPagamento> val) {
            formasPagamento = val;
            return this;
        }

        public Builder withInformacoesAdicionaisFisco(String val) {
            informacoesAdicionaisFisco = val;
            return this;
        }

        public Builder withInformacoesAdicionaisContribuinte(String val) {
            informacoesAdicionaisContribuinte = val;
            return this;
        }

        public Builder withUfLocalEmbarque(NFeUnidadeFederativaEnum val) {
            ufLocalEmbarque = val;
            return this;
        }

        public Builder withLocalEmbarque(String val) {
            localEmbarque = val;
            return this;
        }

        public Builder withLocalDespacho(String val) {
            localDespacho = val;
            return this;
        }

        public NFeRequisicao build() {
            return new NFeRequisicao(this);
        }
    }
}