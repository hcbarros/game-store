
export const numberMask = (evt, serie) => {

    let value = evt.target.value;
    value = value.replace(serie ? /([^1-9])/g : /\D/g,"");
    evt.target.value = value;             
}

export const cepMask = async (evt) => {
    let value = evt.target.value;
    value = value.replace(/\D/g,"")
                 .replace(/(\d{5})(\d)/,"$1-$2") 
    evt.target.value = value;             
}

export const cpfMask = (evt) => {

    let value = evt.target.value;
    value = value.replace(/\D/g,"")
                 .replace(/(\d{3})(\d)/,"$1.$2")
                 .replace(/(\d{3})(\d)/,"$1.$2")
                 .replace(/(\d{3})(\d{1,2})$/,"$1-$2")    

    evt.target.value = value;             
}

export const cardMask = (evt) => {

    let value = evt.target.value;
    value = value.replace(/\D/g,"")
                 .replace(/(\d{4})(\d)/,"$1 $2")
                 .replace(/(\d{4})(\d)/,"$1 $2")
                 .replace(/(\d{4})(\d)/,"$1 $2")
                 .replace(/(\d{4})(\d)/,"");    

    evt.target.value = value;             
}