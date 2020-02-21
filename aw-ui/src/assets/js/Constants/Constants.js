const SELL_PRODUCT = 'SELL_PRODUCT';
const RETURN_PRODUCT = 'RETURN_PRODUCT';
const BUY_PRODUCT = 'BUY_PRODUCT';
const ADD_PRODUCT = 'ADD_PRODUCT';
const CHANGE_PRICE = 'CHANGE_PRICE';

//
export const ProductActions = {
    SELL : {type : SELL_PRODUCT, text : 'Sell Product'},
    RETURN : {type: RETURN_PRODUCT, text : 'Return Product'},
    BUY: {type: BUY_PRODUCT, text : 'Purchase Product'},
    ADD : {type: ADD_PRODUCT, text: 'Add Product'},
    CHANGE_PRICE : {type: CHANGE_PRICE, text: 'Change Price'}
}

const LOGIN_ACTION = 'LOGIN_ACTION';
const LOGOUT_ACTION = 'LOGOUT_ACTION';
const REGISTER_ACTION = 'REGISTER_ACTION';

//
export const AccessActions = {
    LOGIN : {type: LOGIN_ACTION, text : 'Login'},
    REGISTER : {type: REGISTER_ACTION, text : 'Register'},
    LOGOUT : {type: LOGOUT_ACTION, text : 'Logout'}
}

export const Constants = {
    MENUS_URL : 'http://localhost:3000/menus.json'
}

export const EMAIL_REGEX = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/