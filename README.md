# Binary Search Visualizer (Java)

二分探索（Binary Search）を「結果だけでなく、途中の処理ステップごとに理解する」ための学習用プログラムです。

---

## 🚀 概要

通常の二分探索は「見つかった or 見つからない」だけを返しますが、このプログラムでは、

- 探索の過程
- left / right / mid の変化
- 判断の理由

をすべて **ステップ形式で可視化** します。

👉 アルゴリズムを「動き」で理解できるようにしています。

---

## 🧠 二分探索とは？

ソートされた配列に対して高速に探索を行うアルゴリズムです。

### 流れ

1. 配列の真ん中（mid）を見る
2. 目標値と比較する
3. 左か右のどちらかを捨てる
4. 見つかるまで繰り返す

👉 計算量は **O(log n)** と非常に高速

---

## 📂 クラス構成

### BinarySearchVisualizer

メインのクラス

#### 🔹 SearchResult
探索結果をまとめるクラス

- `index`：見つかった位置（なければ -1）
- `steps`：探索の途中経過

#### 🔹 binarySearchWithSteps()

二分探索を行い、処理の流れを steps に記録するメソッド

---

## 💻 実行方法

```bash
javac BinarySearchVisualizer.java
java BinarySearchVisualizer
