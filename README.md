# 🚀 SIT708 Task 5.1: NewsApp & iTubeApp 🚀

> A sleek, futuristic Android application suite demonstrating RecyclerView, Fragments, and YouTube Player API integration—designed and built for Deakin University’s Mobile Application Development unit.

---

## 🔮 Table of Contents

1. [About](#about)  
2. [Features](#features)  
3. [Tech Stack](#tech-stack)  
4. [Demo Videos](#demo-videos)  
5. [Screenshots](#screenshots)  
6. [Getting Started](#getting-started)  
7. [Usage](#usage)  
8. [Project Structure](#project-structure)  
9. [Contributing](#contributing)  
10. [License](#license)  

---

## 🌟 About

This repository contains two cutting‑edge Android applications:

1. **NewsApp** – A news reader featuring horizontal RecyclerViews for Top Stories and Latest News, with dynamic fragment navigation to detailed articles and related news feeds.  
2. **iTubeApp** – A lightweight YouTube client that embeds videos via the YouTube Player API and lets users create, store, and manage custom playlists using Room database.

Both apps share a single-activity architecture, Material‑inspired UI components, and follow modern Android best practices.

---

## ✨ Features

### NewsApp
- 📰 **Horizontal RecyclerViews** for “Top Stories” and “Latest News”  
- 🔍 **Detail Fragment** showing headline, image, and full description  
- 🔄 **Related News Feed** implemented as a vertical RecyclerView  
- 🚦 **One-Activity Architecture** with Fragment navigation  

### iTubeApp
- ▶️ **Embedded YouTube Player** for seamless video playback  
- 📚 **Playlist Management** with Room database persistence  
- ➕ **Add & Remove Videos** from custom playlists  
- 💾 **Local Storage** of playlists for offline access  

---

## 🛠 Tech Stack

| Component              | Technology                    |
|------------------------|-------------------------------|
| Language               | Java                          |
| UI Framework           | Android SDK (RecyclerView, Fragments, Material Components) |
| Media Integration      | YouTube Player API (iframe)  |
| Persistence            | Room Database                 |
| Build System           | Gradle / Kotlin DSL           |
| Min SDK                | API Level 21+                 |

---

## 🎥 Demo Videos

- **NewsApp Demo**:  
  https://www.youtube.com/shorts/hnCl2mD1MMY?feature=share  

- **iTubeApp Demo**:  
  https://www.youtube.com/shorts/jnEzPWnb1Zw?feature=share  

---

## 📸 Screenshots
| NewsApp – Home                                                                                             | NewsApp – Detail                                                                                             |
| :--------------------------------------------------------------------------------------------------------- | :----------------------------------------------------------------------------------------------------------- |
| <img src="https://github.com/user-attachments/assets/3cbb0ac4-71ed-47c6-8e45-af388a2ebdfa" width="200" /> | <img src="https://github.com/user-attachments/assets/eaaa4be6-a90d-4cb2-8354-00fc9bee224a" width="200" /> |

| iTubeApp – Playlist                                                                                        | iTubeApp – Player                                                                                          |
| :--------------------------------------------------------------------------------------------------------- | :--------------------------------------------------------------------------------------------------------- |
| <img src="https://github.com/user-attachments/assets/8f20502b-9ffd-474e-9cca-22dfd6c390ed" width="200" /> | <img src="https://github.com/user-attachments/assets/e5c37c0a-b275-413b-a90b-8e6988015ec5" width="200" /> |

---

## 🚀 Getting Started

1. **Clone the repository**  
   ```bash
   git clone https://github.com/Tillu6/SIT708--Task-5.1.git
   cd SIT708--Task-5.1
   ```

2. **Open in Android Studio**  
   - Select **Open an existing project**  
   - Navigate to the `NewsApp` or `iTubeApp` folder  

3. **Build & Run**  
   - Let Gradle sync  
   - Run on a physical device or emulator (min SDK 21)  

---

## 💡 Usage

- **NewsApp**:  
  - Browse “Top Stories” or swipe through “Latest News.”  
  - Tap any story to view the full article and related news recommendations.  

- **iTubeApp**:  
  - Enter YouTube video URLs to add to your playlist.  
  - Tap a video thumbnail to load the embedded player.  
  - Use the playlist screen to manage your saved videos.  

---

## 🗂 Project Structure

```
SIT708--Task-5.1/
├── NewsApp/
│   ├── app/
│   │   ├── src/main/java/...   ← Java source & Fragments
│   │   └── src/main/res/...    ← Layouts, Drawables, Values
│   ├── build.gradle.kts
│   └── gradle.properties
└── iTubeApp/
    ├── app/
    │   ├── src/main/java/...   ← YouTube API integration & Room
    │   └── src/main/res/...    ← Layouts, Drawables, Values
    ├── build.gradle.kts
    └── gradle.properties
```

---

## 🤝 Contributing

Contributions, issues, and feature requests are welcome!  
Feel free to open a pull request or an issue.
---

*Crafted with ❤️ by Saketh Reddy Poreddy*  
