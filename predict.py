from joblib import load
import numpy as np
import pandas as pd
import sklearn

def predict(X_new):
    # 저장된 모델 불러오기
    model = load('model.joblib')

    # 예측 수행
    predictions = model.predict(X_new)

    # 예측 결과 출력
    print(predictions[0])
    return predictions

if __name__ == '__main__':
    # 새로운 데이터를 저장
    example_data = {
    'ph': 7.0,
    'Hardness': 150.0,
    'Solids': 10000.0,
    'Chloramines': 7.0,
    'Sulfate': 250.0,
    'Conductivity': 400.0,
    'Organic_carbon': 15.0,
    'Trihalomethanes': 80.0,
    'Turbidity': 3.5
    }

    # DataFrame으로 변환
    X_new = pd.DataFrame([example_data])

    # predict 함수를 호출
    predict(X_new)