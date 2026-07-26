# 🎓 Polygnan Student Project Hub - Backend API

An internal RESTful backend service built for Polygnan to manage student and fellow project submissions, tracking status approvals, and automated workflow updates.

---

## 🏗 System Architecture

```text
┌─────────────────────────────────┐
│     React Frontend (Vite)       │
│  - Student Submission Form      │
│  - Host Mode Access Control     │
└────────────────┬────────────────┘
                 │
                 │ REST API (JSON)
                 ▼
┌─────────────────────────────────┐
│    Spring Boot Backend (Java)   │
│  - ProjectController (CORS)     │
│  - ProjectSubmission Entity     │
│  - ProjectRepository (JPA)      │
└────────────────┬────────────────┘
                 │
                 │ JDBC / Hibernate
                 ▼
┌─────────────────────────────────┐
│        MySQL Database           │
│  - project_submissions Table    │
└─────────────────────────────────┘
