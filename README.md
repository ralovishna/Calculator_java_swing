🧮 Modern Java Swing Calculator
A sleek, dark-themed calculator built with Java Swing, inspired by the modern look of Mi Phones and Windows Calculator. Designed with elegance and functionality in mind — it’s clean, responsive, and built smart under the hood.

✨ Features
🖤 Modern dark UI with clean button layout
🖱️ Mouse click support and ⌨️ keyboard input support
🔁 Dynamic button creation using arrays and for loops
✅ Robust calculation engine with input parsing
🧩 Handles edge cases smoothly (like multiple zeros or incomplete expressions)

🖥️ Interface & Layout
The calculator’s UI is designed to be minimal, sharp, and modern. Instead of manually writing each button, buttons are defined in arrays and rendered using for loops — making the layout logic clean and scalable.

⌨️ Keyboard + Mouse Support
This calculator supports both:
🖱 Mouse Input: Click buttons with the mouse like a traditional calculator.
⌨️ Keyboard Input: Type directly using your keyboard for faster operation. Key bindings are mapped to match button labels.

🧠 Smart Calculation Logic
Once an expression is completed, the input string is split into:
An array of numbers
An array of operators
Then, the app performs operations in the correct order. Key highlights:
Supports multi-digit numbers and decimal points
Handles mixed expressions like 12 + 3 * 5
Gracefully manages input errors or malformed expressions

🔍 Edge Case Handling
This calculator is built to handle tricky inputs smoothly:
Leading Zeros: Pressing 0 when the screen is empty shows 0. Pressing 0 again becomes 00, and it continues — handled cleanly.
Multiple Numbers, One Operator: Logic supports calculating with one operator and multiple numbers intelligently.
Empty Input: Pressing buttons when no number is shown behaves predictably — no crashes or weird output.

🚀 Tech Stack
Language: Java
UI Framework: Swing
Platform: Desktop GUI Application

📁 How to Run
Clone the repository:
git clone https://github.com/yourusername/modern-swing-calculator.git
cd modern-swing-calculator

Open the project in your Java IDE (IntelliJ, Eclipse, etc.)
Run the Main.java or the main class containing public static void main.

🧭 Roadmap / Possible Additions
 Scientific mode
 Light/Dark theme toggle
 Copy result to clipboard
 Expression history

👨‍💻 Author
Built with passion by Krishna
Inspired by clean, real-world calculator designs.
