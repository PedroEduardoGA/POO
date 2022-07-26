import React from 'react';
import {
  View,
  Text,
  StyleSheet,
  ScrollView,
  TextInput,
  TouchableOpacity
} from 'react-native';
 
import { colors } from './Cores';
 
class Banda extends React.Component {
  state = {
    nomeMusica: '',
    anoLancamento: '',
    album: ''
  }

  onChangeText = (key, value) => {
    this.setState({
      [key]: value
    })
  }

  adicionarMusica = () => {
    if (this.state.nomeMusica === '' || this.state.anoLancamento === ''){
      alert('Favor preencher campos!')
      return;
    } 
    const { banda } = this.props.route.params
    const musica = {
      nomeMusica: this.state.nomeMusica,
      anoLancamento: this.state.anoLancamento,
      album: this.state.album
    }
    this.props.adicionarMusica(musica, banda)
    this.setState({ nomeMusica: '', anoLancamento: '', album: '' })
  }
  
  render() {
    const { banda } = this.props.route.params
    return (
      <View style={{ flex: 1 }}>
        <ScrollView contentContainerStyle={[!banda.musicas.length && { flex: 1 }]}>
          <View style={[styles.containerMusicas, !banda.musicas.length && { flex: 1, justifyContent: 'center' }]}>
            {
              !banda.musicas.length && <Text style={styles.message}>Sem músicas salvas...</Text>
            }
            {
              banda.musicas.map((musica, index) => (
                <View key={index} style={styles.containerMusica}>
                  <Text style={styles.txtNome}>{musica.nomeMusica}</Text>
                  <Text style={styles.txtAno}>{musica.album}</Text>
                  <Text style={styles.txtAno}>{musica.anoLancamento}</Text>
                </View>
              ))
            }
          </View>
        </ScrollView>
        <TextInput
          onChangeText={val => this.onChangeText('nomeMusica', val)}
          placeholder='*Nome da música'
          value={this.state.nomeMusica}
          style={styles.input}
          placeholderTextColor={colors.secundary}
        />
        <TextInput
          onChangeText={val => this.onChangeText('anoLancamento', val)}
          placeholder='*Ano de lançamento'
          value={this.state.anoLancamento}
          style={[styles.input, styles.input2]}
          placeholderTextColor={colors.secundary}
        />
        <TextInput
          onChangeText={val => this.onChangeText('album', val)}
          placeholder='Album'
          value={this.state.album}
          style={[styles.input, styles.input2, styles.input3]}
          placeholderTextColor={colors.secundary}
        />
        <View style={styles.buttonContainer}>
          <TouchableOpacity onPress={this.adicionarMusica}>
            <View style={styles.button}>
              <Text style={styles.buttonText}>Adicionar música</Text>
            </View>
          </TouchableOpacity>
        </View>
      </View>
    )
  }
}
 
const styles = StyleSheet.create({
  container: {
    flex: 1
  },
  containerMusicas: {
    paddingBottom: 110
  },
  input: {
    height: 50,
    backgroundColor: colors.primary,
    color: colors.secundary,
    paddingHorizontal: 8,
    position: 'absolute',
    width: '100%',
    bottom: 150,
    borderWidth: 1,
    borderBottomColor: colors.background,
  },
  input2: {
    bottom: 100
  },
  input3: {
    bottom: 50
  },
  buttonContainer: {
    position: 'absolute',
    bottom: 0,
    left: 0,
    width: '100%',
    borderBottomColor: colors.background,
  },
  button: {
    height: 50,
    backgroundColor: colors.primary,
    justifyContent: 'center',
    alignItems: 'center'
  },
  buttonText: {
    color: colors.secundary
  },
  containerMusica: {
    padding: 10,
    borderBottomWidth: 2,
    borderBottomColor: colors.details,
    backgroundColor: colors.primary
  },
  txtNome: {
    fontSize: 20,
    color: colors.background
  },
  txtAno: {
    color: colors.secundary,
    fontStyle: 'italic'
  },
  message: {
    alignSelf: 'center',
    fontSize: 20
  }
})
 
export default Banda