from flask import Flask, request, jsonify
import pandas as pd
import unicodedata
from flask_cors import CORS

app = Flask(__name__)
CORS(app)

df = pd.read_csv('C:/Users/Gean/Desktop/Teste/Relatorio/Relatorio_cadop.csv', sep=';', dtype=str).fillna('')

campos_relevantes = ['Razao_Social', 'Nome_Fantasia', 'Cidade', 'UF', 'Regiao_de_Comercializacao']

def normalizar_texto(texto):
    return unicodedata.normalize('NFKD', texto).encode('ASCII', 'ignore').decode('ASCII').lower()

@app.route('/buscar', methods=['GET'])
def buscar_operadoras():
    termo = request.args.get('q', '').strip()
    termo_normalizado = normalizar_texto(termo)

    page = int(request.args.get('page', 1))
    per_page = int(request.args.get('per_page', 10))
    
    resultados = []
    for _, row in df.iterrows():
        contador = 0
        dados = row.to_dict()
        for campo in campos_relevantes:
            valor = str(dados.get(campo, '')).lower()
            if termo_normalizado in normalizar_texto(valor):
                contador += 1
        if contador > 0:
            dados['relevancia'] = contador
            resultados.append(dados)
    
    resultados_ordenados = sorted(resultados, key=lambda x: x['relevancia'], reverse=True)

    total_results = len(resultados_ordenados)
    start_index = (page - 1) * per_page
    end_index = start_index + per_page
    paginated_results = resultados_ordenados[start_index:end_index]

    return jsonify({
        'total_results': total_results,
        'page': page,
        'per_page': per_page,
        'results': paginated_results
    })

if __name__ == '__main__':
    app.run(host='127.0.0.1', port=5000, debug=True)
