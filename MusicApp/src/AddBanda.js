import React from 'react';
import {
  View,
  Text,
  StyleSheet,
  TextInput,
  TouchableOpacity
} from 'react-native';
 
import * as Random from 'expo-random';
import { colors } from './Cores';
 
class AddBanda extends React.Component {
  state = {
    banda: '',
    genero: ''
  }
 
  onChangeText = (key, value) => {
    this.setState({ [key]: value })
  }

  submit = () => {
    if (this.state.banda === '' || this.state.genero === '') alert('Favor preencher campos!')
    const banda = {
      banda: this.state.banda,
      genero: this.state.genero,
      id: String(Random.getRandomBytes(8)),
      musicas: []
    }
    if (this.state.banda !== '' && this.state.genero !== ''){
      this.props.addBanda(banda)
      alert('Nova banda adicionada!')
    } 

    this.setState({
      banda: '',
      genero: ''
    })
  }
  
  render() {
    return (
       <View style={styles.container}>
        <Text style={styles.titulo}>Nova Banda</Text>
        <TextInput
          placeholder='*Nome da Banda'
          onChangeText={val => this.onChangeText('banda', val)}
          style={styles.input}
          value={this.state.banda}
        />
        <TextInput
          placeholder='*Gênero da Banda'
          onChangeText={val => this.onChangeText('genero', val)}
          style={styles.input}
          value={this.state.genero}
        />
        <TouchableOpacity onPress={this.submit}>
          <View style={styles.button}>
            <Text style={styles.buttonText}>Adicionar</Text>
          </View>
        </TouchableOpacity>
      </View>
    )
  }
}
 
const styles = StyleSheet.create({
  button: {
    height: 50,
    backgroundColor: colors.details,
    justifyContent: 'center',
    alignItems: 'center',
    margin: 70,
    borderColor: colors.background,
    borderWidth: 2
  },
  buttonText: {
    color: colors.background,
    fontSize: 18,
    fontWeight: 'bold'
  },
  titulo: {
    color: colors.background,
    fontSize: 40,
    marginBottom: 15,
    alignSelf: 'center',
    fontFamily: 'verdana'
  },
  container: {
    backgroundColor: colors.primary,
    flex: 1,
    justifyContent: 'center'
  },
  input: {
    margin: 20,
    backgroundColor: colors.secundary,
    paddingHorizontal: 8,
    height: 50,
    borderColor: colors.background,
    borderWidth: 2
  }
})
 
export default AddBanda