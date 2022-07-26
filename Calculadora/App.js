import { View, StyleSheet, Text } from 'react-native'
import React, { Component } from 'react'
import Button from './Button';

class App extends Component {
  constructor(){
    super()

    this.state = {
      valorAtual: '',
      operacao: '',
      firstValue: 0
    }
    this.calculaValores = this.calculaValores.bind(this);
  }
  
  adicionaDigito(char){
    let valor = this.state.valorAtual;
    let op = this.state.operacao;

    switch(char){
        case '+':
          if(op === ''){
            this.setState({operacao: '+'})
            this.setState({firstValue: parseFloat(valor)})
            this.setState({valorAtual: ''})
          }
          break;
        
        case '-':
          if(op === ''){
            this.setState({operacao: '-'})
            this.setState({firstValue: parseFloat(valor)})
            this.setState({valorAtual: ''})
          }
          break;

        case 'x':
          if(op === ''){
            this.setState({operacao: 'x'})
            this.setState({firstValue: parseFloat(valor)})
            this.setState({valorAtual: ''})
          }
          break;

        case '/':
          if(op === ''){
            this.setState({operacao: '/'})
            this.setState({firstValue: parseFloat(valor)})
            this.setState({valorAtual: ''})
          }
          break;

        case '.':
          if(!valor.includes('.'))
              this.setState({valorAtual: valor+char })
          break;

        case '=':
            if(op === '')
              break;
            else{
              let resultado = this.calculaValores(parseFloat(valor)).toString()
              this.setState({valorAtual: resultado, operacao: '', firstValue: parseFloat(resultado)})
            } 
          break;
        
        case '0':
          if(valor !== '')
            this.setState({valorAtual: valor+char })
          break;

        default:
          if(valor.length < 9)
            this.setState({valorAtual: valor+char })
    }
  }

  resetaValores(){
    this.setState({valorAtual: '', operacao: '', firstValue: 0})
  }

  calculaValores(n2){
    let op = this.state.operacao;
    let n1 = this.state.firstValue;
    
    switch(op){
      case '+':
        return n1+n2
      
      case '-':
        return n1-n2
        
      case 'x':
        return n1*n2
      
      case '/':
        return n1/n2
     
      default:
        break;
    }
  }

  render(){
    return(
      <View style={styles.container}>
        <View style={styles.corpoCalc}>
          <View style={styles.visor}>
            <Text style={styles.textoVisor}>{this.state.valorAtual}</Text>
          </View>
          <View style={styles.corpoButtons}>
              <Button onPress={() => this.adicionaDigito('7')} valor='7'></Button>
              <Button onPress={() => this.adicionaDigito('8')} valor='8'></Button>
              <Button onPress={() => this.adicionaDigito('9')} valor='9'></Button>
              <Button onPress={() => this.adicionaDigito('+')} valor='+'></Button>
              <Button onPress={() => this.adicionaDigito('4')} valor='4'></Button>
              <Button onPress={() => this.adicionaDigito('5')} valor='5'></Button>
              <Button onPress={() => this.adicionaDigito('6')} valor='6'></Button>
              <Button onPress={() => this.adicionaDigito('-')} valor='-'></Button>
              <Button onPress={() => this.adicionaDigito('1')} valor='1'></Button>
              <Button onPress={() => this.adicionaDigito('2')} valor='2'></Button>
              <Button onPress={() => this.adicionaDigito('3')} valor='3'></Button>
              <Button onPress={() => this.adicionaDigito('x')} valor='x'></Button>
              <Button onPress={() => this.adicionaDigito('.')} valor='.'></Button>
              <Button onPress={() => this.adicionaDigito('0')} valor='0'></Button>

              <Button onPress={() => this.resetaValores()} valor='CL'></Button>
              <Button onPress={() => this.adicionaDigito('/')} valor='/'></Button>
              <Button onPress={() => this.adicionaDigito('=')} valor='='></Button>
            </View>
        </View>
      </View>
    )
  }
}
 
const styles = StyleSheet.create({
  container: {
    alignItems: 'center',
    flex:1,
    flexDirection: 'row',
    justifyContent: 'center'
  },
  corpoCalc: {
    borderWidth:1,
    borderStyle: 'solid',
    backgroundColor: 'grey',
    justifyContent: 'center',
    borderRadius:15,
    alignItems: 'center',
    width:400,
    height:600
  },
   visor: {
       alignItems: 'left',
       justifyContent: 'center',
       borderStyle: 'solid',
       borderWidth:1,
       borderRadius:30,
       backgroundColor: 'green',
       margin:10,
       width:350,
       height:100
   },
   corpoButtons: {
       backgroundColor: 'lightgrey',
       borderWidth:1,
       borderColor: 'black',
       width:350,
       height:450,
       borderRadius:10,
       padding:5,
       flexDirection: 'row',
       flexWrap: 'wrap',
   },
  textoVisor: {  
    padding:4,
    color: 'chartreuse',  
    fontSize:50,
    fontFamily: 'sans-serif'
  }
});

export default App
