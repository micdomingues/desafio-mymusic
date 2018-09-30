export const messages = {
  'validacoes.limite_minimo_nao_atingido': 'Limite de caracteres mínimo não atingido',
  'validacoes.nao_encontrado': 'Não encontrado'
};

export class TranslateMessagesUtils {

  public static getMessageFrom(codigo: string, sufixo?: string) {
    let mensagem = messages[codigo];
    if (mensagem == null) {
      mensagem = codigo;
    }
    if (sufixo != null) {
      mensagem += sufixo + mensagem;
    }

    return mensagem;
  }

}
