import loader from '../assets/images/loader.gif';
import '../assets/css/main.css';
import React, { useState, useEffect, useRef } from 'react';
import { useStateWithCallbackLazy } from 'use-state-with-callback';
import { useSelector, useDispatch } from 'react-redux';
import {Redirect} from 'react-router-dom';
import $ from 'jquery';
import { initialCart } from '../data/data';
import { setCart, setEndereco, setUsuario } from '../actions/actions';
import Header from '../components/header';
import Api from '../api/api';
import * as masks from '../components/masks';
import { getCEP } from '../components/getCEP';



export default function Endereco() {

    const dispatch = useDispatch();
    const cart = useSelector(state => state.cart);
    const usuario = useSelector(state => state.usuario);
    const endereco = useSelector(state => state.endereco);
    const [init, setInit] = useState(true);
    const [state, setState] = useState("AC");
    const [redirect, setRedirect] = useState(false);
    const [local, setLocal] = useState("/");
    const [loading, setLoading] = useStateWithCallbackLazy(false);
    const nome = useRef(null);
    const cpf = useRef(null);
    const cartao = useRef(null);
    const cep = useRef(null);
    const rua = useRef(null);
    const numero = useRef(null);
    const complemento = useRef(null);
    const bairro = useRef(null);
    const cidade = useRef(null);
    const datePay = useRef(null);


    const CEP = async (evt) => {

        masks.cepMask(evt);
        
        if(cep.current.value.length === 9) {
            const obj = await getCEP(cep, rua, complemento, bairro, cidade);
            if(!obj.cep) cep.current.value = "CEP invalido!"
            else setState(obj.uf);
        }
    }   

    const blindEffect = (e) => {
        setState(e);
        $(".drop").toggle( "blind" );
    }

    const setValues = () => {

        cep.current.value = endereco.endereco.cep;
        rua.current.value = endereco.endereco.rua;
        numero.current.value = endereco.endereco.numero;
        complemento.current.value = endereco.endereco.complemento;
        bairro.current.value = endereco.endereco.bairro;
        cidade.current.value = endereco.endereco.cidade;
        setState(endereco.endereco.estado);

        nome.current.value = usuario.usuario.nome;
        cpf.current.value = usuario.usuario.cpf;
        cartao.current.value = usuario.usuario.cartao;
        dispatch(setUsuario({}));
        dispatch(setEndereco({}));
    }

    const salvar = async () => {

        if(!/\S/.test(rua.current.value) || !/\S/.test(numero.current.value) || 
                !/\S/.test(cidade.current.value)) {
            alert("Preencha os dados do endereço!");
            return;
        }

        if(!/\S/.test(cep.current.value) && cep.current.value.length < 9 ) {
            alert("Formato do CEP inválido!");
            return;
        }
        
        setLoading(true);

        endereco.endereco.cep = cep.current.value;
        endereco.endereco.rua = rua.current.value;
        endereco.endereco.numero = numero.current.value;
        endereco.endereco.complemento = complemento.current.value;
        endereco.endereco.bairro = bairro.current.value;
        endereco.endereco.cidade = cidade.current.value;
        endereco.endereco.estado = state;

        usuario.usuario.nome = nome.current.value;
        usuario.usuario.cpf = cpf.current.value;
        usuario.usuario.cartao = cartao.current.value.replace(/\s/g, '');

        usuario.usuario.endereco = endereco.endereco;
        usuario.usuario.cart = cart.cart;

        dispatch(setUsuario(usuario));
        dispatch(setEndereco(endereco));

        const result = await Api.saveUser(usuario.usuario);

        setLoading(false, () => {
            
            setValues();

            if(typeof result === 'undefined') alert("Houve um erro ao finalizar a compra!");
            
            else if(typeof result.nome !== 'undefined') {
                alert("Compra realizada com sucesso!");
                dispatch(setCart(initialCart));
                setRedirect(true);
            }
            else if(typeof result.erros !== 'undefined') {
                alert(result.erros[0]);
                
            }
        });
    }


    const getInput = (label, max, ref) => {
        return  <tr>
                    <td><b>{label}</b></td>
                    <td className="field-input">
                        <input type="text"  
                        maxLength={max} ref={ref} />
                    </td>    
                </tr>    
    }

    useEffect(() => {

        $(".drop").hide();
        
    }, [init, loading]);


    return (

        <div className="endereco">
            
            <Header main={false} local="/" linkText="Tela inicial" />

            {redirect && <Redirect to={local} />}

            {loading && <div className="loading"><img src={loader} 
            alt="imagem gif carregando" /></div>}

            {!loading &&

            <div>

                <div className="text-editar">Dados pessoais</div>
                <fieldset>
                    <legend>Dados pessoais</legend>

                    <table>
                        
                        {getInput("Nome:", "100", nome)}
                        
                        <tr>
                            <td><b>CPF:</b></td>
                            <td className="field-input">
                                <input type="text" maxLength="14" name="cpf"
                                onKeyUp={(evt) => masks.cpfMask(evt)} onKeyDown={(evt) => masks.cpfMask(evt)} 
                                ref={cpf} />
                            </td>    
                        </tr>   

                        <tr>
                            <td><b>Cartão:</b></td>
                            <td className="field-input">
                                <input type="text" maxLength="19" name="cartao"
                                onKeyUp={(evt) => masks.cardMask(evt)} onKeyDown={(evt) => masks.cardMask(evt)} 
                                ref={cartao} />
                            </td>    
                        </tr>   

                        <tr>
                            <td><b>CEP:</b></td>
                            <td className="field-input">
                                <input type="text" maxLength="9" minLength="1" name="cep"
                                onKeyUp={(evt) => CEP(evt)} onKeyDown={(evt) => CEP(evt)} 
                                ref={cep} />
                            </td>    
                        </tr>   
                        
                        {getInput("Rua:", "120", rua)}
                        
                        <tr>
                            <td><b>Número:</b></td>
                            <td className="field-input">
                                <input type="text" name="numero" ref={numero} 
                                maxLength="9" onKeyUp={(evt) => masks.numberMask(evt,false)} 
                                onKeyDown={(evt) => masks.numberMask(evt,false)} />
                            </td>    
                        </tr>    

                        {getInput("Complemento:", "50", complemento)}
                        {getInput("Bairro:", "100", bairro)}
                        {getInput("Cidade:", "100", cidade)}

                        <tr>
                            <td><b>Estado:</b></td>
                            <td className="field-input">
                                <div className="estados">
                                    <div className="estado" onClick={() => blindEffect("AC")}
                                        ><div className="estado-init">{state}</div><div className="arrow"></div></div>

                                    {['AL','AP','AM','BA','CE','DF','ES','GO','MA','MT','MS','MG','PA',
                                      'PB','PR','PE','PI','RJ','RN','RS','RO','RR','SC','SP','SE','TO']
                                      .map(e => <div className="drop"
                                                        onClick={() => blindEffect(e)}>
                                                    {e}
                                                </div>)}
                                </div>
                            </td>    
                        </tr>                        
                    </table>

                    <div className="buttons-editar">
                        <div><button onClick={() => salvar()} >Finalizar compra</button></div>
                        <div><button onClick={() => {
                                setLocal("/cart"); setRedirect(true);
                            }} >
                            Voltar</button></div>
                    </div>

                </fieldset>

            </div>}

        </div>
    );
}