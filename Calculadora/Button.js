import { StyleSheet, TouchableHighlight, Text } from 'react-native'
import React, { Component } from 'react'

const Button = ({ onPress, valor}) => (
    <TouchableHighlight
        onPress={onPress}
            underlayColor='#efefef'
            style={[valor === '=' ? styles.buttonEqual : styles.button]}>
            <Text style={styles.texto}>
                {valor}
            </Text>
    </TouchableHighlight>
)

const styles = StyleSheet.create({
    button: {
        backgroundColor: 'grey',
        borderRadius:5,
        margin: 'auto',
        width:70,
        height:70,
        justifyContent: 'center',
        alignItems: 'center'
    },
    texto: {    
        fontWeight: 'bold',
        fontSize:40
    },
    buttonEqual: {
        backgroundColor: 'grey',
        borderRadius:5,
        margin: 'auto',
        width:280,
        height:50,
        justifyContent: 'center',
        alignItems: 'center'
    }
});

export default Button